package ob.unibanca.sicf.tarifarios.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.spring.validation.validation.CaracterRequerido;
import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class TarifarioVISA {

    @IdNumerico(maxRange = 999999, groups = IRegistro.class)
    private Integer idTarifarioVISA; // el PK en la base de datos es idProgramaComision
    @IdNumerico(maxRange = 99, groups = IRegistro.class)
    private Integer idTipoComision;
    private String descripcionTipoComision;
    private String descripcionProgramaComision;
    private String descripcionComision;
    private double tarifaPorcentaje;
    @IdNumerico(maxRange = 99, groups = IRegistro.class)
    private Integer idMonedaTarFlat;
    @CaracterRequerido(maxLength = 60)
    private String descripcionMoneda;
    private double tarifaFlat;

}
