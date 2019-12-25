package ob.unibanca.sicf.consultasgenerales.model.binvisa;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.spring.validation.validation.IdCadena;
import ob.commons.spring.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BINVisa {
	@IdCadena(minLength = 6, maxLength = 15, regexpPattern = "[0-9]+", groups = IRegistro.class)
	String idBIN;
	String binProcesador;
	String region;
	String pais;
	String tipoBIN;
	String participacionFlag;
	String visaDirect;
	String binTifBypassFlag;
	String multinationalMerchantAccept;
	String domesticOctPif;
	String crossBorderOctPif;
	String octGeoBlocking;
	String testIndicator;
	String oboIndicator;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaProceso;
}
