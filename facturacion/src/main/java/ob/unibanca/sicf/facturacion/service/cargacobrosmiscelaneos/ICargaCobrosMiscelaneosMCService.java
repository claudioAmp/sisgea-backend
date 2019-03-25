package ob.unibanca.sicf.facturacion.service.cargacobrosmiscelaneos;

import ob.commons.error.model.ErrorResponse;
import ob.commons.excel.usermodel.ICargaService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ICargaCobrosMiscelaneosMCService extends ICargaService {
	
	List<ErrorResponse> cargarArchivos(List<MultipartFile> file);
}