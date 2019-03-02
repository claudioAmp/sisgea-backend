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

    @IdNumerico(maxRange = 99999, groups = IRegistro.class)
    private Integer idClaseTransaccion;
    @IdNumerico(maxRange = 99999)
    private Integer idCodigoTransaccion;
    @CaracterRequerido(minLength = 1, maxLength = 100)
    private String descripcion;
    @CaracterRequerido(minLength = 1, maxLength = 20)
    private String descripcionCorta;
    @IdNumerico(maxRange = 99999)
    private Integer idCodigoFacturacion;
    @IdNumerico(maxRange = 99999)
    private Integer aplicaCompensacion;
    @IdNumerico(maxRange = 99999)
    private Integer compensaFondos;
    @IdNumerico(maxRange = 99999)
    private Integer compensaComisiones;

}
