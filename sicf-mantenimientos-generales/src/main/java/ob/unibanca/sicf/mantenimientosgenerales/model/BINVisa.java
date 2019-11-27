package ob.unibanca.sicf.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.spring.validation.validation.IdCadena;
import ob.commons.spring.validation.validation.group.IRegistro;
import ob.unibanca.sicf.mantenimientosgenerales.model.BIN.BINBuilder;

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
}