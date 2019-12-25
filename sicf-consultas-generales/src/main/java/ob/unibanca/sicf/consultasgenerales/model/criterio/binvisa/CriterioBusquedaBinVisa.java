package ob.unibanca.sicf.consultasgenerales.model.criterio.binvisa;

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
public class CriterioBusquedaBinVisa {
	private String idBIN;
	private String binProcesador;
	private String region;
	private List<String> pais;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProcesoInicio;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProcesoFin;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProceso;
	//Filtros de cabeceras
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date filtroFechaProceso;
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
	private String ordenFechaProceso;
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
