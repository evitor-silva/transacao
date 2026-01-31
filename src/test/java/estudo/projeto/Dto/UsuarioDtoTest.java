package estudo.projeto.Dto;

import estudo.projeto.Dto.Usuario.UsuarioDto;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.*;

import static jakarta.validation.Validation.buildDefaultValidatorFactory;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioDtoTest {

    @Mock
    private Validator validator;

    @BeforeEach
    void setUp(){
        Validator validator;
        try (ValidatorFactory validatorFactory = buildDefaultValidatorFactory()) {
            this.validator = validatorFactory.getValidator();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void deveValidarRetornarErroSenhadoUsuario(){
        UsuarioDto usuario = new UsuarioDto("nome6c","senha");

        Set<ConstraintViolation<UsuarioDto>> violations = validator.validate(usuario);
        violations.forEach(v -> { assertEquals("A senha deve ter pelo menos 6 caracteres", v.getMessageTemplate());});

        assertEquals(1, violations.size());
    }

    @Test
    void deveValidarRetornarErroNomeDoUsuario(){
        UsuarioDto usuario = new UsuarioDto("nome6","senha12");

        Set<ConstraintViolation<UsuarioDto>> violations = validator.validate(usuario);
        violations.forEach(v -> { assertEquals("O Nome deve ter pelo menos 6 caracteres", v.getMessageTemplate());});

        assertEquals(1, violations.size());
    }

    @Test
    void deveValidarRetornarDoisErros(){
        List<String> violationsArray = List.of( "O Nome deve ter pelo menos 6 caracteres", "A senha deve ter pelo menos 6 caracteres" );
        UsuarioDto usuario = new UsuarioDto("nome","senha");
        Set<ConstraintViolation<UsuarioDto>> violations = validator.validate(usuario);

        violations.forEach((x) -> {
            boolean exist = violationsArray.stream().anyMatch(s -> s.equals(x.getMessageTemplate()));
            if(!exist){
                try {
                    throw new Exception("As Violações do UsuarioDTO não foram encontradas.");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        assertEquals(2, violations.size());
    }
}