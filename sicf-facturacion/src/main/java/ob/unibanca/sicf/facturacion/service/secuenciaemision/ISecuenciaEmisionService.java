package ob.unibanca.sicf.facturacion.service.secuenciaemision;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.facturacion.model.SecuenciaEmision;

import java.util.List;

public interface ISecuenciaEmisionService extends IMantenibleService<SecuenciaEmision> {

    List<SecuenciaEmision> buscarTodasSecuenciasEmisiones();

    SecuenciaEmision buscarSecuenciaEmision(Integer idSecuenciaEmision);

    SecuenciaEmision registrarSecuenciaEmision(SecuenciaEmision secuenciaEmision);

    SecuenciaEmision actualizarSecuenciaEmision(Integer idSecuenciaEmision, SecuenciaEmision secuenciaEmision);

    void eliminarSecuenciaEmision(Integer idSecuenciaEmision);
}
