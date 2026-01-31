package estudo.projeto.Dto.Usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioDto(
        @NotBlank(message = "Campo name necessário")
        @Size(min = 6, message = "O Nome deve ter pelo menos 6 caracteres")
        String name,

        @NotBlank(message = "Campo password necessário")
        @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres")
        String password
) {
    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }
}
