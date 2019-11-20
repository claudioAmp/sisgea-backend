package ob.unibanca.sicf.tarifarios.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.NumeroNoRequerido;
import ob.commons.spring.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TarifarioEmisor {
	
	private int idTarifarioEmisor;
	@IdNumerico(maxRange = 99999, groups = IRegistro.class)
	private int idInstitucion;
	private String descripcionInstitucion;
	@IdNumerico(maxRange = 99, groups = IRegistro.class)
	private int idTarifa;
	private String descripcionTarifa;
	@IdNumerico(maxRange = 99, groups = IRegistro.class)
	private int nivel;
	@IdNumerico(minRange = 0, maxRange = 99, groups = IRegistro.class)
	private int idGrupoBIN;
	private String descripcionGrupoBIN;
	@IdNumerico(maxRange = 999999, groups = IRegistro.class)
	private int transaccion;
	@IdNumerico(maxRange = 99999999, groups = IRegistro.class)
	private int rangoInicial;
	@IdNumerico(maxRange = 99999999, groups = IRegistro.class)
	private int rangoFinal;
	@NumeroNoRequerido(maxRange = 999)
	private int idMoneda;
	private String descripcionMoneda;
	private double tarifaFlat;
	private double tarifaPorcentual;
	private boolean aplicaIGV;

}
