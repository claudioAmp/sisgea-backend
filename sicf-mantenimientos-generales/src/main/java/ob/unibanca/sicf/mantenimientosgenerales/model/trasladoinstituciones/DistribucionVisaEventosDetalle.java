package ob.unibanca.sicf.mantenimientosgenerales.model.trasladoinstituciones;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DistribucionVisaEventosDetalle {

    private int idInstitucion;
    private String descripcionInstitucion;

    private int instUnits;
    private double valorTransaccionInst;
    
}
