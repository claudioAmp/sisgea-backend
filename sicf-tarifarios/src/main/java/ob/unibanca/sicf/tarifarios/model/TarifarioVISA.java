package ob.unibanca.sicf.tarifarios.model;

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

public class TarifarioVISA {

    @IdCadena(maxLength = 4)
    private String idTarifarioVisa; // el PK en la base de datos es idProgramaComision
    @IdNumerico(maxRange = 999, groups = IRegistro.class)
    private Integer idTipoComision;
    private String descripcionTipoComision;
    private String descripcionProgramaComision;
    private String descripcionComision;
    private double tarifaPorcentaje;
    @IdNumerico(maxRange = 999, groups = IRegistro.class)
    private Integer idMonedaTarFlat;
    private String descripcionMoneda;
    private double tarifaFlat;

}
