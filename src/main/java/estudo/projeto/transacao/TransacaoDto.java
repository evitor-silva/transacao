package estudo.projeto.transacao;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class TransacaoDto {
    private BigDecimal valor;
    private OffsetDateTime dataHora;

    public TransacaoDto(BigDecimal valor, OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;

        validarTransacao(this);
    }

    private void validarTransacao(TransacaoDto transacaoRequest) {
        if (transacaoRequest.getValor().compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Valor Transacao invalido");
        else if (transacaoRequest.getDataHora().isAfter(OffsetDateTime.now()))
            throw new IllegalArgumentException("Data de transacao inválida");
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

    public BigDecimal getValor() {
        return valor;
    }

}
