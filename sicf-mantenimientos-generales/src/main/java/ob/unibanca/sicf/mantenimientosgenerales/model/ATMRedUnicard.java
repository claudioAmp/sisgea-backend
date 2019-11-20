package ob.unibanca.sicf.mantenimientosgenerales.model;

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
public class ATMRedUnicard {
	
	@IdNumerico(maxRange = 99999, groups = IRegistro.class)
	private Integer idATM;
	@IdNumerico(maxRange = 99999)
	private Integer idInstitucion;
	@CaracterRequerido(maxLength = 40)
	private String nombre;
	@CaracterRequerido(maxLength = 60)
	private String direccion;
	private String descripcionInstitucion;
	
	private Integer tipo;   // 1 RED UNICARD - 2 RED ASOCIADA
	
}
