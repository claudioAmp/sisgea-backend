package ob.unibanca.sicf.facturacion.service.cargacobrosmiscelaneos;

import ob.commons.excel.usermodel.ICargaService;

import org.springframework.web.multipart.MultipartFile;

public interface ICargaCobrosMiscelaneosVisaService extends ICargaService {

   public String cargarArchivos(MultipartFile file);

}