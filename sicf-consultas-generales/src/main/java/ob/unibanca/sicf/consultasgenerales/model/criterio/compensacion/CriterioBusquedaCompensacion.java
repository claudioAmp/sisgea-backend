package ob.unibanca.sicf.consultasgenerales.model.criterio.compensacion;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaCompensacion {
	String fechaProcesoInicio;
	String fechaProcesoFin;
	Integer idSecuencia;
	String numeroTarjeta;
	List<Integer> monedasCompensacion;
	double valorCompensacion;
	String numeroTrace;
	List<String> membresias;
	List<String> servicios;
	List<Integer> origenes;
	List<Integer> clasesTransaccion;
	List<Integer> codigosTransaccion;
	List<Integer> roles;
	List<Integer> canales;
	List<Integer> instituciones;
	List<Integer> institucionesReceptoras;
	List<String> bines;
	List<String> codigosRespuesta;
}
