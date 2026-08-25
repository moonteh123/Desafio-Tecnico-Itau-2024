package dev.Java10x.itau.Java10x.Estatisticas;

import dev.Java10x.itau.Java10x.Docs.EstatisticaControllerDoc;
import dev.Java10x.itau.Java10x.Transacao;
import dev.Java10x.itau.Java10x.TransacaoRepository;
import dev.Java10x.itau.Java10x.TransacaoRequest;
import dev.Java10x.itau.Java10x.TransacaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/estatistica")
public class EstatisticasController implements EstatisticaControllerDoc {

    private final EstatisticasProp estatisticasProp;
    private final TransacaoRepository transacaoRepository;

    public EstatisticasController(EstatisticasProp estatisticasProp, TransacaoRepository transacaoRepository) {
        this.estatisticasProp = estatisticasProp;
        this.transacaoRepository = transacaoRepository;
    }

    @GetMapping
    public ResponseEntity<EstaticaDTO> estatisticas() {
        log.info("Carregando as estatisticas de transacoes feitas nos ultimos " + estatisticasProp.segundos() + " segundos");

        if (transacaoRepository.getTransacoes().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        OffsetDateTime horaInicial =
                OffsetDateTime.now().minusSeconds(estatisticasProp.segundos());

        EstaticaDTO estatisticas =
                transacaoRepository.getEstatisticas(horaInicial);

        return ResponseEntity.ok(estatisticas);
    }
}
