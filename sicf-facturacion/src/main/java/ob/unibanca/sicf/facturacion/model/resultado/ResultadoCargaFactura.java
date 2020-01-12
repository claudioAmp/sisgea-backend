package ob.unibanca.sicf.facturacion.model.resultado;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultadoCargaFactura {
	String nombreArchivo;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaFactura;
	Boolean exito;
	Integer numeroRegistros;
}
