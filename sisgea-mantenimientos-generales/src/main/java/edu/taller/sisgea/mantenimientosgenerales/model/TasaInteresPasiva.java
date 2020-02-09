package edu.taller.sisgea.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TasaInteresPasiva {
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaProceso;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaAfectMonedaBase;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaAfectMonedaAlterna;

    private Double tasaInteresMonedaBase;
    private Double tasaInteresMonedaAlterna;

    private BigDecimal factorDiarioMonedaBase;
    private BigDecimal factorDiarioMonedaAlterna;
}
