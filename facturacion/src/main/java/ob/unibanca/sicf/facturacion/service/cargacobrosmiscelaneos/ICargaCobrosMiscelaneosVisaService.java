package ob.unibanca.sicf.facturacion.service.cargacobrosmiscelaneos;

import ob.commons.error.model.ErrorResponse;
import ob.commons.excel.usermodel.ICargaService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface ICargaCobrosMiscelaneosVisaService extends ICargaService {
	
	List<ErrorResponse> cargarArchivos(List<MultipartFile> file);
	
	void cargarRegistro(Map<String, Object> registro);
}