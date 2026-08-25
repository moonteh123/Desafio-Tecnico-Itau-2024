package dev.Java10x.itau.Java10x.Docs;

import dev.Java10x.itau.Java10x.TransacaoRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;


@Tag(
        name = "transacoes",
        description = "Endpoints responsaveis por criar"
)
public interface TransacaoControllerDoc {
    @Operation(
            summary = "Cria novas transacoes e adiciona em uma lista",
            description = "Recebe uma transacao pos validacao e adiciona na lista"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Transacao criada com sucesso"
    )
    @ApiResponse(
            responseCode = "422",
            description = "Erro de validacao capturado"

    )
    @ApiResponse(
            responseCode = "400",
            description = "Erro inesperado no servidor"
    )

    public ResponseEntity criar(@RequestBody TransacaoRequest transacaoRequest);

    @Operation(
            summary = "Busca as transacoes salvas",
            description = "Busca e retorna todas as transacoes salvas"
    )

    @ApiResponse(
            responseCode = "201",
            description = "Lista de transacoes retornada com sucesso"
    )

    @ApiResponse(
            responseCode = "400",
            description = "nenhuma transacao armazenada"
    )

    public ResponseEntity<List<TransacaoRequest>> getAll();

    @Operation(
            summary = "Delecao de transacoes",
            description = "Endpoint para deletar todas as transacoes armazenadas"
    )

    @ApiResponse(
            responseCode = "200",
            description = "Todas as transacoes armazenadas foram deletadas com sucesso"
    )

    @ApiResponse(
            responseCode = "500",
            description = "Erro inesperado, nao ha transacoes a serem deletadas"
    )

    public ResponseEntity deleteAll();
}
