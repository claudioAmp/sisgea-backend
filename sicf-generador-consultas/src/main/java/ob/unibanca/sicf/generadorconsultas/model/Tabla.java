package ob.unibanca.sicf.generadorconsultas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tabla {
	int idTabla;
	String nombre;
	String descripcion;
	String desCorta;
	String alias;
	String idTipoTabla;
	String tipoTabla;
}