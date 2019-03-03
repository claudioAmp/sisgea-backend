package ob.unibanca.sicf.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.validation.validation.CaracterRequerido;
import ob.commons.validation.validation.IdNumerico;
import ob.commons.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CodigoTransaccion {

    @IdNumerico(maxRange = 9999, groups = IRegistro.class)
    private Integer idClaseTransaccion;
    @IdNumerico(maxRange = 9999, groups = IRegistro.class)
    private Integer idCodigoTransaccion;
    @CaracterRequerido(maxLength = 100)
    private String descripcion;
    @CaracterRequerido(maxLength = 20)
    private String descripcionCorta;
    @IdNumerico(maxRange = 99999, groups = IRegistro.class)
    private boolean idCodigoFacturacion;
    private boolean aplicaCompensacion;
    private boolean compensaFondos;
    private boolean compensaComisiones;

}
