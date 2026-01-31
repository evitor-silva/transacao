package estudo.projeto.controllers;

import estudo.projeto.Dto.Estatistica.EstatisticaResponseDto;
import estudo.projeto.Dto.TransacaoDto;
import estudo.projeto.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<EstatisticaResponseDto> create(@RequestBody TransacaoDto transactionRequest) {
        EstatisticaResponseDto transacao = transacaoService.add(transactionRequest);
        return ResponseEntity.status(201).body(transacao);
    }

    @DeleteMapping
    public ResponseEntity<String> limpar() {
        transacaoService.limpar();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
