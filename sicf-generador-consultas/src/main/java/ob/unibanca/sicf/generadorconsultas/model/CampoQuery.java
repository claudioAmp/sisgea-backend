package ob.unibanca.sicf.generadorconsultas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CampoQuery {
	Integer idCampoQuery;
	int idTablaQuery;
	int idReporte;
    int idTabla;
    String tabla;
    String idInstanciaTabla;
    int idCampo;
    String campo;
    String aliasCampo;
    String enOrderBy;
    int ordenOrderBy;
    boolean enSelect;
    String funcionGrupo;
    String idTipoDato;
    int permitido;

}
