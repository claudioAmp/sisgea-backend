package ob.unibanca.sicf.tarifarios.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.validation.validation.IdNumerico;
import ob.commons.validation.validation.NumeroNoRequerido;
import ob.commons.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TarifarioSurcharge {
	
	private int idTarifarioSurcharge;
	@IdNumerico(maxRange = 99999, groups = IRegistro.class)
	private int idInstitucion;
	private String descripcionInstitucion;
	@IdNumerico(minRange = 0, maxRange = 99, groups = IRegistro.class)
	private int tipoATM;
	@IdNumerico(maxRange = 99, groups = IRegistro.class)
	private int nivel;
	@IdNumerico(maxRange = 99999999, groups = IRegistro.class)
	private int rangoInicial;
	@IdNumerico(maxRange = 99999999, groups = IRegistro.class)
	private int rangoFinal;
	@NumeroNoRequerido(minRange = 0, maxRange = 999)
	private int idMoneda;
	private String descripcionMoneda;
	private double tarifaFlat;
	private double tarifaPorcentual;
	private boolean aplicaIGV;
	private String descripcionTipoAtm;

}
