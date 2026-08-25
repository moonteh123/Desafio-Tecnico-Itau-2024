package dev.Java10x.itau.Java10x.Docs;


import dev.Java10x.itau.Java10x.Estatisticas.EstaticaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

public interface EstatisticaControllerDoc {
    @Tag(
            name = "Estatisticas",
            description = "Endpoints responsaveis por mostrar dados das estatisticas"
    )
        @Operation(
                summary = "Retorna as estatisticas das ultimas transacoes nos ultimos 60 segundos",
                description = "Recebe uma transacao pos validacao e adiciona na lista"
        )
        @ApiResponse(
                responseCode = "200",
                description = "Estatisticas retornadas com sucesso"
        )
        @ApiResponse(
                responseCode = "422",
                description = "Erro de validacao capturado"

        )
        @ApiResponse(
                responseCode = "400",
                description = "Erro inesperado no servidor"
        )

    public ResponseEntity<EstaticaDTO> estatisticas();

}
