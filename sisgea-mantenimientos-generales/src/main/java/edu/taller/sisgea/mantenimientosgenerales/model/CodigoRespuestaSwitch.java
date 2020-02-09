package edu.taller.sisgea.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.spring.validation.validation.CaracterRequerido;
import ob.commons.spring.validation.validation.IdCadena;
import ob.commons.spring.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CodigoRespuestaSwitch {

    @IdCadena(minLength = 1, maxLength = 4, regexpPattern = "[0-9]+", groups = IRegistro.class)
    private String idCodigoRespuestaSwitch;
    @CaracterRequerido(maxLength = 40)
    private String descripcionCodigoRptaSwitch;
}
