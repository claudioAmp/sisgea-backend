package ob.unibanca.sicf.facturacion.service.cargacobrosmiscelaneos;

import ob.commons.excel.usermodel.ICargaService;

import ob.commons.validation.model.ErrorResponse;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ICargaCobrosMiscelaneosVisaService extends ICargaService {

   public List<ErrorResponse> cargarArchivos(List<MultipartFile> file);

}