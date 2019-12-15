package ob.unibanca.sicf.facturacion.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.spring.validation.validation.CaracterRequerido;
import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FacturaVisa {
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
    int units;        //UNITS	N
    String rateCur;        //RATE_CUR	(null)
    double rate;        //RATE	N
    double foreignExchange;        //FOREIGN_EXCHANGE_RATE	N
    String billingCurrency;        //BILLING_CURRENCY	(null)
    double total;        //TOTAL	N
}
