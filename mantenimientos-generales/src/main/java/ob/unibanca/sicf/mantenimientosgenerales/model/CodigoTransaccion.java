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
public class CodigoTransaccion {
	
	private int idClaseTransaccion;
	private String descripcionClaseTransaccion;
	@IdNumerico(maxRange = 9999, groups = IRegistro.class)
	private int idCodigoTransaccion;
	@CaracterRequerido(maxLength = 100)
	private String descripcionCodigoTransaccion;
	@CaracterRequerido(maxLength = 20)
	private String descripcionCorta;
	@IdNumerico(maxRange = 99999)
	private boolean idCodigoFacturacion;
	private String descripcionCodigofacturacion;
	private boolean aplicaCompensacion;
	private boolean compensaFondos;
	private boolean compensaComisiones;
}
