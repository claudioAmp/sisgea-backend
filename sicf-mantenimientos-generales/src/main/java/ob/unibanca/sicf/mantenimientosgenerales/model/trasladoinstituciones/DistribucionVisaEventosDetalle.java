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

    // Solo para actualización, no son propios de la entidades, heredados de DistribucionVisaEventos
    
    private String secuenciaAgrupada;
    private boolean indUnits;
    
}
