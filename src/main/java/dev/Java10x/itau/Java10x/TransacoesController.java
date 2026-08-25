package dev.Java10x.itau.Java10x;

import dev.Java10x.itau.Java10x.Docs.TransacaoControllerDoc;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/transacao")

public class TransacoesController implements TransacaoControllerDoc {
    private final TransacaoService transacaoService;
    private final TransacaoRepository transacaoRepository;

    public TransacoesController(TransacaoService transacaoService, TransacaoRepository transacaoRepository) {
        this.transacaoService = transacaoService;
        this.transacaoRepository = transacaoRepository;
    }
    /*Criar nova transacao*/
    @PostMapping

    public ResponseEntity criar (@RequestBody TransacaoRequest transacaoRequest) {
        try {

            transacaoService.validarTransacao(transacaoRequest);
            transacaoRepository.salvarDados(transacaoRequest);
            log.info("Transacao passou em todas validacoes e foi criada com sucesso");
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (IllegalArgumentException exception) {
            log.error("Erro em uma ou mais transacoes, por favor tente novamente");
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).build();
        } catch (Exception e) {
            log.error("Erro ao completar transacao: dados mal informados, por favor tente novamente");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }


    }
    /*get todas as transacoes*/
    @GetMapping
    public ResponseEntity<List<TransacaoRequest>> getAll() {
        log.info("Buscando todas as transacoes armazenadas");
        return ResponseEntity.ok(transacaoRepository.getTransacoes());
    }

    @DeleteMapping
    public ResponseEntity deleteAll() {
        log.info("Buscando transacoes a serem deletadas");

        try {
            if(transacaoRepository.getTransacoes().isEmpty()) {
                log.info("Nao temos transacoes armazenadas para serem deletadas");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

            } else {
                transacaoRepository.deletarDados();
                log.info("Transacoes removidas com sucesso");
                return ResponseEntity.ok(transacaoRepository.getTransacoes());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
