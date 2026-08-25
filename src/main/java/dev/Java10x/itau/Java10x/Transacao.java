package dev.Java10x.itau.Java10x;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Transacao {

    private BigDecimal valor;

    private OffsetDateTime dataHora;

}
