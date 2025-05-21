package estudo.projeto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import estudo.projeto.transacao.TransacaoRepository;
import estudo.projeto.transacao.TransacaoRequest;

@SpringBootTest
class ProjetoApplicationTests {

	@Test
	void contextLoads() {
		TransacaoRequest transacao = new TransacaoRequest(new BigDecimal("100.50"), OffsetDateTime.now());
		final TransacaoRepository dd = new TransacaoRepository();
		System.out.println(dd.estatistica(null));
	}

}
