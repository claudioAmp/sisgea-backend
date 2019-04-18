package ob.unibanca.sicf.mantenimientosgenerales.model.criterio;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaInstitucion {
	private Integer idInstitucionOperador;
	private String operador; // 'LIKE' = igual , 'NOT LIKE' = no igual
}
