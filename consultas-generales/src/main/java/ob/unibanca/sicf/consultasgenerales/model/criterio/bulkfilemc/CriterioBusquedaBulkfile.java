package ob.unibanca.sicf.consultasgenerales.model.criterio.bulkfilemc;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaBulkfile {
	String messageTypeInd;
	String transactionDateInicio;
	String transactionDateFin;
	String accountNumber;
	String traceNumber;
	List<Integer> responseCode;
	String fechaProcesoInicio;
	String fechaProcesoFin;
}
