package ob.unibanca.sicf.consultasgenerales.model.criterio.binvisa;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaBinVisa {
	private String idBIN;
	private String binProcesador;
	private String region;
	private List<String> pais;
	//Filtros de cabeceras
	private String filtroIdBIN;
	private String filtroBinProcesador;
	private String filtroRegion;
	private String filtroPais;
	private String filtroTipoBIN;
	private String filtroParticipacionFlag;
	private String filtroVisaDirect;
	private String filtroBinTifBypassFlag;
	private String filtroMultinationalMerchantAccept;
	private String filtroDomesticOctPif;
	private String filtroCrossBorderOctPif;
	private String filtroOctGeoBlocking;
	private String filtroTestIndicator;
	private String filtroOboIndicator;
	//orden de cabeceras
	private String ordenIdBIN;
	private String ordenBinProcesador;
	private String ordenRegion;
	private String ordenPais;
	private String ordenTipoBIN;
	private String ordenParticipacionFlag;
	private String ordenVisaDirect;
	private String ordenBinTifBypassFlag;
	private String ordenMultinationalMerchantAccept;
	private String ordenDomesticOctPif;
	private String ordenCrossBorderOctPif;
	private String ordenOctGeoBlocking;
	private String ordenTestIndicator;
	private String ordenOboIndicator;
}
