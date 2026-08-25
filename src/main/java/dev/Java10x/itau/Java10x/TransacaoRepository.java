package dev.Java10x.itau.Java10x;

import dev.Java10x.itau.Java10x.Estatisticas.EstaticaDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
@Slf4j
@Repository
public class TransacaoRepository {

    List<TransacaoRequest> transacoes = new ArrayList<>();
    List<EstaticaDTO> estatisticas = new ArrayList<>();


    //salvar dados

    public void salvarDados(TransacaoRequest transacaoRequest) {
        transacoes.add(transacaoRequest);

    }

    /*deleta os dados dentro de 60seg*/
    public void limparDados(TransacaoRequest transacaoRequest) {


    }

    /*deleta todos os dados*/
    public void deletarDados() {
        if(transacoes.isEmpty()) {
            throw new RuntimeException("Nao foi posssivel concluir a operacao pois nao ha transacoes a serem deletadas");
        } else {
            transacoes.clear();
        }

    }
    /*retorna todas as transacoes que ocorreram*/
    public List<TransacaoRequest> getTransacoes() {
        return transacoes;
    }

    /*gerar estatisticas*/

    public EstaticaDTO getEstatisticas(OffsetDateTime horaInicial) {
        /*checa se a lista de transacoes esta vazia, se esta, retorna tudo 0*/
        if (transacoes.isEmpty()) {
            return new EstaticaDTO(0L, 0, 0, 0, 0);
        }

        System.out.println("=================================");
        System.out.println("Hora inicial: " + horaInicial);
        System.out.println("Transações cadastradas:");

        transacoes.forEach(t ->
                System.out.println("Transação: " + t.getData())
        );

        System.out.println("Transações que passaram pelo filtro:");

        transacoes.stream()
                .filter(t ->
                        t.getData().isAfter(horaInicial)
                                || t.getData().isEqual(horaInicial)
                )
                .forEach(t ->
                        System.out.println("PASSOU: " + t.getData())
                );
                /*filtra as transacoes na lista de transacoes
                * que ocorreram entre o limite de tempo
                * delimitado(60seg)*/
        final var summary = transacoes.stream()
                .filter(t ->
                        t.getData().isAfter(horaInicial)
                                || t.getData().isEqual(horaInicial)
                )
                .mapToDouble(t -> t.getValor().doubleValue())
                .summaryStatistics();

        System.out.println("Quantidade encontrada: " + summary.getCount());
        System.out.println("=================================");

        if (summary.getCount() == 0) {
            return new EstaticaDTO(0L, 0, 0, 0, 0);
        }

        return new EstaticaDTO(
                summary.getCount(),
                summary.getAverage(),
                summary.getMax(),
                summary.getMin(),
                summary.getSum()
        );
    }

}
