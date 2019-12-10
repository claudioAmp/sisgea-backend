package ob.unibanca.sicf.consultasgenerales.model.irregular;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Irregular {
	private Integer secuencia;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProceso;
	private String idOrigenArchivo;
	private Integer idTipoIrregular;

	private String idMembresia;
	private String descMembresia;
	private String idServicio;
	private String descServicio;
	private Integer idOrigen;
	private String descOrigen;
	private Integer idClaseTransaccion;
	private String descClaseTransaccion;
	private Integer idCodigoTransaccion;
	private String descCodigoTransaccion;
	private Integer idInstitucionEmisora;
	private String descInstitucionEmisora;
	private Integer idInstitucionReceptora;
	private String descInstitucionReceptora;
}
