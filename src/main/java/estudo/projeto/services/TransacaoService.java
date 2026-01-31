package estudo.projeto.services;

import estudo.projeto.Dto.Estatistica.EstatisticaResponseDto;
import estudo.projeto.Dto.TransacaoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.DoubleStream;

@Service
public class TransacaoService {


    private final List<TransacaoDto> transacao = new ArrayList<TransacaoDto>();

    public EstatisticaResponseDto add(TransacaoDto transacaoDto) {
        if (transacaoDto.getValor().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Valor Transacao invalido");
        }
        if (transacaoDto.getDataHora().isAfter(OffsetDateTime.now())) {
            throw new IllegalArgumentException("Data de transacao inválida");
        }

        transacao.add(transacaoDto);

        DoubleSummaryStatistics stats = new DoubleSummaryStatistics();
        stats.accept(transacaoDto.getValor().doubleValue());

        return new EstatisticaResponseDto(stats);
    }

    public EstatisticaResponseDto estatistica(OffsetDateTime horaInicial) {

        if (transacao.isEmpty()) {
            return new EstatisticaResponseDto(new DoubleSummaryStatistics());
        }

        final BigDecimal[] valoresFiltrados = transacao.stream()
                .filter(t -> t.getDataHora().isAfter(horaInicial) || t.getDataHora().equals(horaInicial))
                .map(TransacaoDto::getValor).toArray(BigDecimal[]::new);
        DoubleStream doubleStream = Arrays.stream(valoresFiltrados).mapToDouble(BigDecimal::doubleValue);

        return new EstatisticaResponseDto(doubleStream.summaryStatistics());
    }

    public void limpar() {
        transacao.clear();
    }

}
