package ob.unibanca.sicf.mantenimientosgenerales.model.trasladoinstituciones;

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

public class DistribucionVisaTC10Detalle {

    private String secuencia;

    private Integer idInstitucion;
    private String descripcionInstitucion;

    private double valorTransaccionInst;

    // Solo para inserción, no son propios de la entidades, heredados de DistribucionVisaTC10
    private String secuenciaAgrupada;
}
