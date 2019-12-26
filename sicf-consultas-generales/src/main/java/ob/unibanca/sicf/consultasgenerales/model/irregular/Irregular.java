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
	private String secuencia;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProceso;
	private String idOrigenArchivo;
	
	private String desOrigenArchivo;
	
	private Integer idTipoIrregular;
	private String descTipoIrregular;
	
	private String idMembresia;
	private String descMembresia;
	private Integer idOrigen;
	private String descOrigen;	
	private String idServicio;
	private String descServicio;
	
	private String transaccion;
	private String descripcionCorta;
	
	private String idCanal;
	private String descCanal;
	private String bin;
	private String descBin;
	private Integer idInstitucionEmisora;
	private String descInstitucionEmisora;
	private Integer idInstitucionReceptora;
	private String descInstitucionReceptora;
	private Integer idProducto;
	private String descProducto;
	private String detalleIrregular;
	
	//filtro
	
	private String filtroSecuencia;
	private String filtroIdOrigenArchivo;
	private String filtroIdTipoIrregular;
	private String filtroIdMembresia;
	private String filtroIdOrigen;	
	private String filtroIdServicio;
	private String filtroTransaccion;
	private String filtroIdCanal;
	private String filtroBin;
	private String filtroIdInstitucionEmisora;
	private String filtroIdInstitucionReceptora;
	//orden
	private String ordenSecuencia;
	private String ordenIdOrigenArchivo;
	private String ordenIdTipoIrregular;
	private String ordenIdMembresia;
	private String ordenIdOrigen;	
	private String ordenIdServicio;
	private String ordenTransaccion;
	private String ordenIdCanal;
	private String ordenBin;
	private String ordenIdInstitucionEmisora;
	private String ordenIdInstitucionReceptora;

	

}
