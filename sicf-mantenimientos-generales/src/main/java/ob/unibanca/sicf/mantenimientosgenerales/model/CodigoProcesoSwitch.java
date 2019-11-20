package ob.unibanca.sicf.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.spring.validation.validation.CaracterRequerido;
import ob.commons.spring.validation.validation.IdCadena;
import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CodigoProcesoSwitch {

    @IdCadena(minLength = 1, maxLength = 2, regexpPattern = "[0-9]+", groups = IRegistro.class)
    private String idCodigoProcesoSwitch;
    @CaracterRequerido(maxLength = 40)
    private String descripcionCodProcesoSwitch;
    @CaracterRequerido(maxLength = 4)
    private String abreviatura;
    @IdNumerico(maxRange = 9999)
    private Integer idClaseTransaccion;
    private String descripcionClaseTransaccion;
    @IdNumerico(maxRange = 9999)
    private Integer idCodigoTransaccion;
    private String descripcionCodigoTransaccion;
    private boolean transaccionMonetaria;
    private boolean aplicaInteres;
    
}
