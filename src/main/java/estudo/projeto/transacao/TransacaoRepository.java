package estudo.projeto.transacao;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;

import org.springframework.stereotype.Repository;

import estudo.projeto.estatistica.EstatisticaDto;

@Repository
public class TransacaoRepository {
    private final List<TransacaoRequest> transacao = new ArrayList();

    public List<TransacaoRequest> getTransacao() {
        return transacao;
    }

    public void add(TransacaoRequest transacaoRequest) {
        transacao.add(transacaoRequest);
    }

    public void limpar() {
        transacao.clear();
    }

    public EstatisticaDto estatistica(OffsetDateTime horaInicial) {

        if (transacao.isEmpty()) {
            return new EstatisticaDto();
        } else {

            final BigDecimal[] valoresFiltrados = transacao.stream()
                    .filter(t -> t.getDataHora().isAfter(horaInicial) || t.getDataHora().equals(horaInicial))
                    .map(t -> t.getValor()).toArray(BigDecimal[]::new);
            DoubleStream doubleStream = Arrays.stream(valoresFiltrados).mapToDouble(BigDecimal::doubleValue);
            
            return new EstatisticaDto(doubleStream.summaryStatistics());
        }
    }
}
