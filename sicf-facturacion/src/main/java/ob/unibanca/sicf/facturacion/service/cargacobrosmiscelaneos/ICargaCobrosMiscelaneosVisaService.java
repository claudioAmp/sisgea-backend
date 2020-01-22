package ob.unibanca.sicf.facturacion.service.cargacobrosmiscelaneos;

import ob.commons.excel.usermodel.ICargaService;
import ob.unibanca.sicf.facturacion.model.resultado.ResultadoCargaFactura;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface ICargaCobrosMiscelaneosVisaService extends ICargaService {
	
	List<ResultadoCargaFactura> cargarArchivos(List<MultipartFile> multipartfiles);
	
	void cargarRegistro(Map<String, Object> registro);
}