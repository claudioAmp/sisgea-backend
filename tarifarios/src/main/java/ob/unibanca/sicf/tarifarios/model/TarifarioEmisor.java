package ob.unibanca.sicf.tarifarios.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.validation.validation.IdNumerico;
import ob.commons.validation.validation.group.IRegistro;

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
	@IdNumerico(maxRange = 99, groups = IRegistro.class)
	private int idGrupoBIN;
	@IdNumerico(maxRange = 999999, groups = IRegistro.class)
	private int transaccion;
	@IdNumerico(maxRange = 99999999, groups = IRegistro.class)
	private int rangoInicial;
	@IdNumerico(maxRange = 99999999, groups = IRegistro.class)
	private int rangoFinal;
	private int idMoneda;
	private String descripcionMoneda;
	private Double tarifaFlat;
	private Double tarifaPorcentual;
	private int aplicaIGV;

}
