package ob.unibanca.sicf.mantenimientosgenerales.model.trasladoinstituciones;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class DistribucionVisaTC10 {

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaProceso;

    private String secuenciaAgrupada;

    private String idMembresia;
    private String descripcionMembresia;

    private String idServicio;
    private String descripcionServicio;

    private Integer idOrigen;
    private String descripcionOrigen;

    private Integer idClaseTransaccion;
    private Integer idCodigoTransaccion;
    private String descripcionTransaccion;

    private Integer idMoneda;
    private String descripcionMoneda;

    private double valorTransaccionTotal;

    private String codigoRespuesta;

    private Integer origenArchivo;

    private String entityType;
    private String entityId;

    private String indicadorCompensacion;

    private String numeroTrace;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaTransaccion;

    private List<DistribucionVisaTC10Detalle> listaDistribucion;
}
