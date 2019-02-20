package ob.unibanca.sicf.facturacion.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Portafolio {

    private String idPortafolio;
    private String descripcionPortafolio;
}
