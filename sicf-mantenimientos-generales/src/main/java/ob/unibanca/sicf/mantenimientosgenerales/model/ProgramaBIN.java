package ob.unibanca.sicf.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.spring.validation.validation.IdCadena;
import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProgramaBIN {

    @IdCadena(maxLength = 1, regexpPattern = "[a-zA-Z]")
    private String idMembresia;

    private String descripcionMembresia;

    @IdNumerico(maxRange = 99999)
    private Integer idProducto;

    private String descripcionProducto;

    // TODO(model-programa-bin): que indica el atributo
    //  GROUPS=IRegistro.class en @IdCadena y @IdNumerico
    @IdNumerico(maxRange = 99999)
    private Integer idPrograma;

    private String descripcionPrograma;

    @IdNumerico(maxRange = 99999)
    private Integer idProgramaIntercambio;

    private String descripcionProgramaIntercambio;
}
