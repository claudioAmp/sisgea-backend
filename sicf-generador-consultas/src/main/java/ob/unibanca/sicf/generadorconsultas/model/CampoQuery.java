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
    String aliasTabla;
    String idInstanciaTabla;
    int idCampo;
    String campo;
    String aliasCampo;
    String aliasEnQuery;
    String enOrderBy;
    int ordenOrderBy;
    boolean enSelect;
    int idFuncionGrupo;
    String funcionGrupo;
    String idTipoDato;
    int permitido;

}
