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
    int idReporte;
    int idTabla;
    String tabla;
    String idInstanciaTabla;
    int idCampo;
    String campo;
    int idTablaFrom;
    int idCampoFrom;
    String orderBy;
    boolean enSelect;
    boolean enGroupBy;
    String funcionGrupo;

}
