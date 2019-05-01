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
    int idQuery;
    int idTabla;
    String idInstancia;
    int idCampo;
    int idTablaFrom;
    int idCampoFrom;
    String aliasCampo;
    String orderBy;
    int enSelect;
    int enGroupBy;
    String funcionGrupo;
    /*private String ususarioAdicion;
    private String usuarioModificacion;
    private Date fechaAdicion;
    private Date fechaModificacion;*/

}
