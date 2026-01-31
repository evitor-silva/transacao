package estudo.projeto.controllers;

import estudo.projeto.Dto.Usuario.UsuarioDto;
import estudo.projeto.Dto.Usuario.UsuarioResponseDto;
import estudo.projeto.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/register")
    public ResponseEntity<UsuarioResponseDto> register(@RequestBody @Valid UsuarioDto usuarioDto) {
        UsuarioResponseDto response = usuarioService.createUser(usuarioDto);
        return ResponseEntity.status(201).body(
                response
        );
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioResponseDto> login(@RequestBody UsuarioDto usuario) {
        UsuarioResponseDto response = usuarioService.login(usuario);
        return ResponseEntity.status(200).body(
                response
        );
    }
}
