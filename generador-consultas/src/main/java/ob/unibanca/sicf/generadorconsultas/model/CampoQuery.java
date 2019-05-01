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
    private int idQuery;
    private int idTabla;
    private String idInstancia;
    private int idCampo;
    private int idTablaFrom;
    private int idCampoFrom;
    private String aliasCampo;
    private String orderBy;
    private int enSelect;
    private int enGroupBy;
    private String funcionGrupo;
    private String ususarioAdicion;
    private String usuarioModificacion;
    private Date fechaAdicion;
    private Date fechaModificacion;

}
