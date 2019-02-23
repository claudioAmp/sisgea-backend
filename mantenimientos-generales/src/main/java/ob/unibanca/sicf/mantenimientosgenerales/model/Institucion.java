package ob.unibanca.sicf.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Institucion {
	
	private int idInstitucion;
	private String descripcion;
	private String descripcionCorta;
	private String razonSocial;
	private String ruc;
	private String direccion;
	private boolean bancoAdministrador;
	private String tipoInstitucion;
	private boolean procesador;
	private String cuentaContableMonedaBase;
	private String cuentaContableMonedaAlterna;
	private int idInstitucionOperador;
}
