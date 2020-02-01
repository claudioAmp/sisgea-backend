package ob.unibanca.sicf.facturacion.service.secuenciaemision;

import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.facturacion.mapper.ISecuenciaEmisionMapper;
import ob.unibanca.sicf.facturacion.model.SecuenciaEmision;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SecuenciaEmisionService extends MantenibleService<SecuenciaEmision> implements ISecuenciaEmisionService{

    private static  final String SECUENCIA_EMISION_NO_ENCONTRADO = "La Secuencia Emisión %s no existe";
    private final ISecuenciaEmisionMapper secuenciaEmisionMapper;

    public SecuenciaEmisionService(@Qualifier("ISecuenciaEmisionMapper") IMantenibleMapper<SecuenciaEmision> mantenibleMapper) {
        super(mantenibleMapper);
        this.secuenciaEmisionMapper = (ISecuenciaEmisionMapper) mantenibleMapper;

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<SecuenciaEmision> buscarTodasSecuenciasEmisiones() {
        return this.buscarTodos();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public SecuenciaEmision buscarSecuenciaEmision(Integer idSecuenciaEmision) {
        return this.secuenciaEmisionMapper.buscarSecuenciaEmision(idSecuenciaEmision).orElseThrow(
                () -> new RecursoNoEncontradoException(SECUENCIA_EMISION_NO_ENCONTRADO, idSecuenciaEmision));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public SecuenciaEmision registrarSecuenciaEmision(SecuenciaEmision secuenciaEmision) {
        this.registrar(secuenciaEmision);
        return this.buscarSecuenciaEmision(secuenciaEmision.getIdSecuenciaEmision());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public SecuenciaEmision actualizarSecuenciaEmision(Integer idSecuenciaEmision, SecuenciaEmision secuenciaEmision) {
        secuenciaEmision.setIdSecuenciaEmision(idSecuenciaEmision);
        this.actualizar(secuenciaEmision);
        return this.buscarSecuenciaEmision(secuenciaEmision.getIdSecuenciaEmision());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void eliminarSecuenciaEmision(Integer idSecuenciaEmision) {
        SecuenciaEmision secuenciaEmision = SecuenciaEmision.builder().idSecuenciaEmision(idSecuenciaEmision).build();
        this.eliminar(secuenciaEmision);
    }
}
