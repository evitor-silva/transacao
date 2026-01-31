package estudo.projeto.services;

import estudo.projeto.Entity.Usuario;
import estudo.projeto.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @Bean
    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private Usuario usuario;

    @BeforeEach
    void setUp() {
        Usuario usuario = new Usuario("dddddd", "$2a$10$oYkjpUWCxOFziM6GHCHLhOlhVh1/QulcRZt10k37iFZw9PULGdT.i");//senha123
        when(usuarioRepository.findByName(usuario.getName())).thenReturn(Optional.of(usuario));
        this.usuario = usuario;
    }

    @Test
    void createUserDeveSalvarUsuario() {
        Usuario usuario1 = usuarioRepository.findByName(usuario.getName()).orElseThrow(() -> new RuntimeException("Credenciais inválidas"));

        boolean verify = passwordEncoder().matches("senha123", usuario1.getPassword());

        if(!verify) throw new RuntimeException("Credenciais inválidas");

        assertTrue(verify);
    }

}
