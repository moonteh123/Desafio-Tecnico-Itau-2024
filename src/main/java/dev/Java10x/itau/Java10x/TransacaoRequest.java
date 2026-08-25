package dev.Java10x.itau.Java10x;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransacaoRequest {
    @NotNull(message = "O valor inserido no cmapo valor deve ser maior ou igual a 0")
    @Positive(message = "O valor deve ser positivo e maior que 0")
    private BigDecimal valor;

    @NotNull(message = "O campo de data deve ser preenchido corretamente")
    @PastOrPresent(message = "Impossivel de realizar transacoes futuras")
    private OffsetDateTime data;
}
