package ob.unibanca.sicf.consultasgenerales.model.criterio.liberacion;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaLiberacion {
	
	String estadoTransaccion;
	List<String> origenesArchivo;
	Integer indConciliacion;
	Integer transactionCurrency;
	List<String> messagesTypeInd;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaTransaccionInicio; // transmissionDate
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaTransaccionFin; // transmissionDate
	String accountNumber;
	String traceNumber;
	Long secuenciaSwdmplog;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaTransaccion;
	
}