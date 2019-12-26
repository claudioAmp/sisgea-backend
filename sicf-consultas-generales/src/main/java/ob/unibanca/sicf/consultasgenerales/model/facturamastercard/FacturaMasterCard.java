package ob.unibanca.sicf.consultasgenerales.model.facturamastercard;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FacturaMasterCard {
	private String idRegistroMc;
	private String documentType;
	private String invoiceNumber;
	private String currency;
	private Date billingCycleDate;
	private String invoiceIca;
	private String activiteIca;
	private String serviceCode;
	private String serviceCodeDescription;
	private String eventId;
	private String eventDescription;
	private String affiliate;
	private String uom;
	private Double quantityAmount;
	private Double rate;
	private Double charge;
	private Double taxCharge;
	private Double totalCharge;
	private String sbfExplanatorytext;
}
