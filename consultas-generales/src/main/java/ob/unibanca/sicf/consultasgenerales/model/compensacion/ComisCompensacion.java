package ob.unibanca.sicf.consultasgenerales.model.compensacion;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComisCompensacion {
	Integer idSecuencia;
	Date fechaProceso;
	Integer idComision;
	String descripcion;
	Integer idCuentaCompensacion;
	String registroContable;
	double valorComision;
	Integer nivelTarifario;
	Integer tarifaFlat;
	Integer tarifaPorcentual;
}
