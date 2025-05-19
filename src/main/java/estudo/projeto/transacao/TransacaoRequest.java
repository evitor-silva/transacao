package estudo.projeto.transacao;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class TransacaoRequest {
    private BigDecimal valor;
    private OffsetDateTime dataHora;

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

    public BigDecimal getValor() {
        return valor;
    }

}
