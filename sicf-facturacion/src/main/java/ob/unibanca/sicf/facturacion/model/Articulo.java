package ob.unibanca.sicf.facturacion.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Articulo {

    private String idArticulo;
    private String descripcionArticulo;
    private String glosaArticulo;
    private Integer idPortafolio;
    private String descripcionPortafolio;
    private String idMembresia;
    private String descripcionMembresia;
    private String idServicio;
    private String descripcionServicio;
    private Integer idCodigoFacturacion;
    private String descripcionCodigoFacturacion;
    private Integer idInstitucion;
    private String descripcionInstitucion;
    private Integer indFacturable;


}
