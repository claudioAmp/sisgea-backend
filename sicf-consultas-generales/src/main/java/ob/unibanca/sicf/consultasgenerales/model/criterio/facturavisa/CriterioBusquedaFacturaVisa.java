package ob.unibanca.sicf.consultasgenerales.model.criterio.facturavisa;

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
public class CriterioBusquedaFacturaVisa {
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaAfectacionInicio;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaAfectacionFin;
	
	private List<String>  entitiesType;
	
	private List<Integer> instituciones;
	
	//filtros
	String filtroIdRegistroVisa;
	String filtroBillingPeriod; 
	@DateTimeFormat(pattern = "dd/MM/yyyy")
    Date   filtroInvoiceDate;    
    String filtroInvoiceAccount; 
    String filtroName;        
    String filtroInvoiceId;      
    String filtroSubInvoice;     
    String filtroEntityType;     
    String filtroEntityId;       
    String filtroBinMap;      
    String filtroSettlementId;   
    String filtroDescription;    
    String filtroBillingLine;    
    String filtroType;        
    String filtroRateType;       
    String filtroUnits;        
    String filtroRateCur;        
    String filtroRate;       
    String filtroForeignExchange;
    String filtroBillingCurrency;
    String filtroTotal; 
	@DateTimeFormat(pattern = "dd/MM/yyyy")
    Date   filtroFechaAfectacionVisa;  
	String filtroInstitucion;
    
    
    //orden
    
	String ordenIdRegistroVisa;
	String ordenBillingPeriod; 
    String ordenInvoiceDate;    
    String ordenInvoiceAccount; 
    String ordenName;        
    String ordenInvoiceId;      
    String ordenSubInvoice;     
    String ordenEntityType;     
    String ordenEntityId;       
    String ordenBinMap;      
    String ordenSettlementId;   
    String ordenDescription;    
    String ordenBillingLine;    
    String ordenType;        
    String ordenRateType;       
    String ordenUnits;        
    String ordenRateCur;        
    String ordenRate;       
    String ordenForeignExchange;
    String ordenBillingCurrency;
    String ordenTotal;   
    String ordenFechaAfectacionVisa;
    String ordenInstitucion;
    
}
