package ob.unibanca.sicf.consultasgenerales.model.criterio.bulkfile;

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
	String fechaTransaccionInicio; //transactionDate
	String fechaTransaccion; //transactionDate
	String fechaTransaccionFin; //transactionDate
	String accountNumber;
	String traceNumber;
	List<Integer> responsesCode; //responseCode
	String fechaProcesoInicio;
	String fechaProcesoFin;
	List<Integer> currencysCodeTran; 
}