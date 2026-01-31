package estudo.projeto.Dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record TransacaoDto(
        @NotBlank(message = "Campo valor necessário")
        BigDecimal valor,

        @NotBlank(message = "Campo dataHora necessário")
        OffsetDateTime dataHora
) {
    public BigDecimal getValor() {
        return valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }
}
