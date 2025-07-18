package estudo.projeto.usuario;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import estudo.projeto.Jwt.JwtService;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public void register(@RequestBody Usuario usuarioDto) {
        usuarioDto.setPassword();
        usuarioRepository.save(usuarioDto);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Usuario usuario) {
        Map<String, String> jwt = new HashMap<>();
        jwt.put("token", jwtService.generateToken(usuario));
        return new ResponseEntity<>(jwt, HttpStatus.OK);
    }
}
