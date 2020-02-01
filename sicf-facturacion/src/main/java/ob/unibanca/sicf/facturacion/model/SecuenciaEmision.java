package ob.unibanca.sicf.facturacion.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SecuenciaEmision {

    private Integer idSecuenciaEmision;
    private Integer origenSolicitud;
    private String tipoDocumento;
    private String descripcionDocumento;
    private String numeroSerie;
    private Integer secuencia;
}
