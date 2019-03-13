package ob.unibanca.sicf.facturacion.service.cargacobrosmiscelaneos;

import ob.commons.excel.usermodel.ICargaService;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ICargaCobrosMiscelaneosMCService extends ICargaService {

   public void cargarArchivos(List<MultipartFile> file);

}