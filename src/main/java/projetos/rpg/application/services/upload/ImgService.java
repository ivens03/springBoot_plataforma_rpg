package projetos.rpg.application.services.upload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import projetos.rpg.domain.model.post.ImgModel;
import projetos.rpg.domain.repository.multiMidia.ImgRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class ImgService {

    private final Path fileStorageLocation;
    private final ImgRepository imgRepository;

    @Autowired
    public ImgService(@Value("${file.upload-dir}") String uploadDir, ImgRepository imgRepository) {

        this.fileStorageLocation = Paths.get(uploadDir).toAbsolutePath().normalize();
        this.imgRepository = imgRepository;

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public ImgModel storeFile(MultipartFile file) {
        // Normalize file name
        String originalFileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        String fileExtension = "";

        try {
            // Check if the file's name contains invalid characters
            if (originalFileName.contains("..")) {
                throw new RuntimeException("Sorry! Filename contains invalid path sequence " + originalFileName);
            }

            // Get file extension
            int lastDotIndex = originalFileName.lastIndexOf('.');
            if (lastDotIndex > 0) {
                fileExtension = originalFileName.substring(lastDotIndex);
            }

            // Generate unique file name
            String fileName = UUID.randomUUID().toString() + fileExtension;

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            // Get the file download URI
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/images/download/")
                    .path(fileName)
                    .toUriString();

            // Create and save image metadata
            ImgModel imgModel = new ImgModel();
            imgModel.setNome_imagem(originalFileName);
            imgModel.setUrl_imagem(fileDownloadUri);
            imgModel.setTamanho_imagem(file.getSize());
            imgModel.setData_criacao(LocalDateTime.now());

            return imgRepository.save(imgModel);

        } catch (IOException ex) {
            throw new RuntimeException("Could not store file " + originalFileName + ". Please try again!", ex);
        }
    }

    public ImgModel getFile(Long fileId) {
        return imgRepository.findById(fileId)
                .orElseThrow(() -> new RuntimeException("File not found with id " + fileId));
    }

    public List<ImgModel> getAllFiles() {
        return imgRepository.findAll();
    }

    public void deleteFile(Long fileId) {
        ImgModel imgModel = getFile(fileId);
        try {
            String fileName = imgModel.getUrl_imagem().substring(imgModel.getUrl_imagem().lastIndexOf("/") + 1);
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Files.deleteIfExists(filePath);
            imgRepository.delete(imgModel);
        } catch (IOException ex) {
            throw new RuntimeException("Could not delete file " + imgModel.getNome_imagem(), ex);
        }
    }
}
