package ob.unibanca.sicf.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReglasCompensacionComision {
	private Integer idTipoComision;
	private String descripcionTipoComision;
	private Integer idCuentaCargoComision;
	private String descripcionCuentaCargoComision;
	private Integer idCuentaAbonoComision;
	private String descripcionCuentaAbonoComision;
}
