package projetos.rpg.infrastructure.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import projetos.rpg.domain.model.jogador.JogadorModel;
import projetos.rpg.domain.repository.jogador.JogadorRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final JogadorRepository jogadorRepository;

    public CustomUserDetailsService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Por padrão, o Spring Security usa o username para autenticação
        // Mas estamos usando o email como username
        JogadorModel jogador = jogadorRepository.findByEmailAndAtivoTrue(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com o email: " + username));
        
        // Lista de autoridades/papeis do usuário
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        
        return new User(
                jogador.getEmail(), // username
                jogador.getPassword(),
                jogador.getAtivo(),
                true, // accountNonExpired
                true, // credentialsNonExpired
                true, // accountNonLocked
                authorities // authorities/roles
        );
    }
}
