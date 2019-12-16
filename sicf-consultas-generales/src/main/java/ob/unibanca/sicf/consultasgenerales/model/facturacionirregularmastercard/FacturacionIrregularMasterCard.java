package ob.unibanca.sicf.consultasgenerales.model.facturacionirregularmastercard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FacturacionIrregularMasterCard {

    private String eventId;
    private String eventDescription;
    private String invoiceNumber;
    private String documentType;
    private String currency;
    private String invoiceIca;
    private String serviceCode;
    private String serviceCodeDescription;
    private String sbfExplanatoryText;
    private Integer registroIrregular;
    private String descripcionIrregularidad;
}
