package ob.unibanca.sicf.consultasgenerales.model.facturavisa;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FacturaVisa {
	String idRegistroVisa;
	String billingPeriod; //BILLING_PERIOD	(null)
    Date invoiceDate;        //INVOICE_DATE	D
    String invoiceAccount;        //INVOICE_ACCOUNT	(null)
    String name;        //NAME	(null)
    String invoiceId;       //INVOICE_ID	(null)
    String subInvoice;        //SUB_INVOICE	(null)
    String entityType;        //ENTITY_TYPE	(null)
    String entityId;        //ENTITY_ID	(null)
    String binMap;        //BIN_MAP	(null)
    String settlementId;        //SETTLEMENT_ID	(null)
    String description;        //DESCRIPTION	(null)
    String billingLine;        //BILLING_LINE	(null)
    String type;        //TYPE	(null)
    String rateType;        //RATE_TYPE	(null)
    Integer units;        //UNITS	N
    String rateCur;        //RATE_CUR	(null)
    Double rate;        //RATE	N
    Double foreignExchange;        //FOREIGN_EXCHANGE_RATE	N
    String billingCurrency;        //BILLING_CURRENCY	(null)
    Double total; 
    Date fechaAfectacionVisa;//TOTAL	N
}
