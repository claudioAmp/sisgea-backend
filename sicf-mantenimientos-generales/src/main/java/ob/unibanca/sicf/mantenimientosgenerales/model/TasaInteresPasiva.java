package ob.unibanca.sicf.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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

    private Float tasaInteresMonedaBase;
    private Float tasaInteresMonedaAlterna;

    private Float factorDiarioMonedaBase;
    private Float factorDiarioMonedaAlterna;
}
