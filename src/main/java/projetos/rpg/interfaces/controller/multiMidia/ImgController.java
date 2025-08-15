package projetos.rpg.interfaces.controller.multiMidia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import projetos.rpg.domain.model.multiMidia.ImgModel;
import projetos.rpg.application.services.upload.ImgService;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImgController {

    @Autowired
    private ImgService imgService;


    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ImgModel> uploadFile(@RequestParam("file") MultipartFile file) {
        ImgModel imgModel = imgService.storeFile(file);
        return ResponseEntity.ok(imgModel);
    }

    @GetMapping("/{fileId}")
    public ResponseEntity<ImgModel> getFileInfo(@PathVariable Long fileId) {
        ImgModel imgModel = imgService.getFile(fileId);
        return ResponseEntity.ok(imgModel);
    }

    @GetMapping
    public ResponseEntity<List<ImgModel>> getAllFiles() {
        return ResponseEntity.ok(imgService.getAllFiles());
    }

    @GetMapping("/download/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) {
        try {
            Path filePath = Paths.get("uploads").toAbsolutePath().normalize().resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_JPEG) // or detect file type
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (MalformedURLException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{fileId}")
    public ResponseEntity<Void> deleteFile(@PathVariable Long fileId) {
        imgService.deleteFile(fileId);
        return ResponseEntity.noContent().build();
    }
}
