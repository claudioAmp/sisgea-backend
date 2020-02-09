package edu.taller.sisgea.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.spring.validation.validation.CaracterRequerido;
import ob.commons.spring.validation.validation.IdCadena;
import ob.commons.spring.validation.validation.IdNumerico;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CodigoRazonCobroVisa {

    @IdCadena(maxLength = 5)
    private String idCodigoRazon;
    @CaracterRequerido(maxLength = 100)
    private String descripcionCodigoRazon;
    @IdNumerico(maxRange = 99999)
    private Integer idClaseTransaccion;
    private Integer idCodigoTransaccion;
    private String descripcionTransaccion;
}
