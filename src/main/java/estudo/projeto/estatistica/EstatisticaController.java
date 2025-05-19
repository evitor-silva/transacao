package estudo.projeto.estatistica;

import java.time.OffsetDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import estudo.projeto.transacao.TransacaoRepository;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {
    private final Integer intervalo = 60;
    private TransacaoRepository transacaoRepository;

    public EstatisticaController(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @GetMapping()
    public ResponseEntity<EstatisticaDto> estatistica() {
        final var horaInicial = OffsetDateTime.now().minusSeconds(intervalo);
        return ResponseEntity.ok(transacaoRepository.estatistica(horaInicial));
    }

}
