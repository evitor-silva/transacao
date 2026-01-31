package estudo.projeto.services;

import estudo.projeto.Dto.Usuario.UsuarioDto;
import estudo.projeto.Entity.Usuario;
import estudo.projeto.Jwt.JwtService;
import estudo.projeto.repository.UsuarioRepository;
import estudo.projeto.Dto.Usuario.UsuarioResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtService jwtService;

    @Bean
    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public UsuarioResponseDto createUser(UsuarioDto usuarioDto) {
        boolean exists = usuarioRepository.existsByName(usuarioDto.getName());

        if (exists) throw new RuntimeException("Usuário já existe");

        String passwordEncrypt = passwordEncoder().encode(usuarioDto.getPassword());

        Usuario usuario = new Usuario(usuarioDto.getName(), passwordEncrypt);
        usuarioRepository.save(usuario);

        return new UsuarioResponseDto(usuario.getName(), jwtService.generateToken(usuario));
    }

    public UsuarioResponseDto login(UsuarioDto usuarioDto) {
        Usuario usuario = usuarioRepository.findByName(usuarioDto.getName()).orElseThrow(() -> new RuntimeException("Credenciais inválidas"));

        boolean verify = passwordEncoder().matches(usuarioDto.getPassword(), usuario.getPassword());

        if (!verify) throw new RuntimeException("Credenciais inválidas");

        return new UsuarioResponseDto(usuario.getName(), jwtService.generateToken(usuario));
    }

}