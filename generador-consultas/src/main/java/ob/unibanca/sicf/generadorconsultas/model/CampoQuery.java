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
	int idCampoQuery;
	int idTablaQuery;
	int idReporte;
    int idTabla;
    String tabla;
    String idInstanciaTabla;
    int idCampo;
    String campo;
    String aliasCampo;
    int idCampoQueryFrom;
    int idCampoFrom;
    int idTablaFrom;
    String idInstanciaTablaFrom;
    String orderBy;
    boolean enSelect;
    boolean enGroupBy;
    String funcionGrupo;

}
