package ob.unibanca.sicf.consultasgenerales.model.facturacionirregularvisa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FacturacionIrregularVisa {

    private Date invoiceDate;
    private String name;
    private String invoiceId;
    private String subInvoice;
    private String billingLine;
    private String description;
    private String entityType;
    private String entityId;
    private String binMap;
    private String rateType;
    private String rateCur;
    private double rate;
    private Integer units;
    private double total;
    private Integer registroIrregular;
    private String descripcionIrregularidad;
}
