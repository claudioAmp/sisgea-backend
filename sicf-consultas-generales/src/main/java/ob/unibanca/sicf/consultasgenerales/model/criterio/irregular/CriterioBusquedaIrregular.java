package ob.unibanca.sicf.consultasgenerales.model.criterio.irregular;

import java.util.Date;

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
public class CriterioBusquedaIrregular {
	//Criterios
	Date fechaProceso;
	Integer idOrigenArchivo;
	Integer idTipoIrregular;
	
	
	//Filtros
}
