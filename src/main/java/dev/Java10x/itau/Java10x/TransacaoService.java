package dev.Java10x.itau.Java10x;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class TransacaoService {

    public void validarTransacao(TransacaoRequest transacaoRequest) {
        if(transacaoRequest.getValor().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Erro: Essa transacao nao  e valida pois as transacoes devem ter valores maior que 0");

        }
        if(transacaoRequest.getData().isAfter(OffsetDateTime.now())) {
            throw new IllegalArgumentException("Erro: Nao e possivel realizar transacoes futuras");
        }

        if(transacaoRequest.getValor() == null) {
            throw new IllegalArgumentException("Erro: Valor nao foi encontrado.");
        }

        if(transacaoRequest.getData() == null) {
            throw new IllegalArgumentException("Erro: Data nao foi encontrado.");
        }

}}
