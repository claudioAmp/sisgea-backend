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
	String idSecuencia;
	Date fechaProceso;
	Integer idComision;
	String descripcionComision;
	Integer idCuentaCompensacion;
	String registroContable;
	Double valorComision;
	Integer nivelTarifario;
	Integer tarifaFlat;
	Integer tarifaPorcentual;
	Integer aplicaTarifaFlat;
	Integer aplicaTarifaPorcentual;
}
