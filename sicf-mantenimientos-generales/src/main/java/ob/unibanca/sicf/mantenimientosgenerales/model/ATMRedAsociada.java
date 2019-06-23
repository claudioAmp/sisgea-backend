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
public class ATMRedAsociada {
	
	@IdNumerico(maxRange = 99999, groups = IRegistro.class)
	private Integer idATM;
	private Integer idInstitucion;
	@CaracterRequerido(maxLength = 40)
	private String nombre;
	@CaracterRequerido(maxLength = 60)
	private String direccion;
	private String descripcionInstitucion;
	
	private Integer tipo;   // 1 RED UNICARD - 2 RED ASOCIADA
}
