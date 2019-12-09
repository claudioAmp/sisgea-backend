package ob.unibanca.sicf.conciliacion.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenerarConciliacion {
	
	private Integer idConcTabla;
	private String idArchivoConciliarA;
	private String idArchivoConciliarB;
	private String tablaConciliarA;
	private String tablaConciliarB;
	private String filtroActualizacionA;
	private String filtroActualizacionB;
	private Integer aplicaExpresionA;
	private String tablaExpresionA;
	private Integer aplicaExpresionB;
	private String tablaExpresionB;
	
	private String tabla;
	private String campo;
	private String tipoDato;
	
	private List<CampoMatching> camposMatching;
	private List<CampoDiferencia> camposDiferencia;
	private List<CampoActualizar> camposActualizar;
	private List<CampoInsertarObservada> camposInsertarObservada;
}
