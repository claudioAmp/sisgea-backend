package ob.unibanca.sicf.facturacion.service.cargacobrosmiscelaneos;

import ob.commons.excel.usermodel.ICargaService;
import java.io.File;

public interface ICargaCobrosMiscelaneosVisaService extends ICargaService {

   public String cargarArchivos(File file);

}