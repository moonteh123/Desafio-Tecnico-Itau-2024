package dev.Java10x.itau.Java10x.Estatisticas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EstaticaDTO {

    private Long count;
    private double sum;
    private double avg;
    private double min;
    private double max;
}
