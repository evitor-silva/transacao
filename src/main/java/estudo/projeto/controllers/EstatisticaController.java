package estudo.projeto.controllers;

import java.time.OffsetDateTime;

import estudo.projeto.Dto.Estatistica.EstatisticaResponseDto;
import estudo.projeto.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {
    private final Integer intervalo = 60;

    @Autowired
    private TransacaoService transacaoRepository;

    @GetMapping()
    public ResponseEntity<EstatisticaResponseDto> estatistica() {
        final var horaInicial = OffsetDateTime.now().minusSeconds(intervalo);
        return ResponseEntity.ok(transacaoRepository.estatistica(horaInicial));
    }

}
