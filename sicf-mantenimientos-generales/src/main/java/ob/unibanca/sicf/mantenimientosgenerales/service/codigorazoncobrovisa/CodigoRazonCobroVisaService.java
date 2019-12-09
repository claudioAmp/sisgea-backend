package ob.unibanca.sicf.mantenimientosgenerales.service.codigorazoncobrovisa;

import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.mapper.ICodigoRazonCobroVisaMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.CodigoRazonCobroVisa;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CodigoRazonCobroVisaService extends MantenibleService<CodigoRazonCobroVisa> implements ICodigoRazonCobroVisaService {
    private static final String CODIGO_RAZON_NO_ENCONTRADO = "No existe un código razón cobro visa";
    private final ICodigoRazonCobroVisaMapper codigoRazonCobroVisaMapper;

    public CodigoRazonCobroVisaService(
            @Qualifier("ICodigoRazonCobroVisaMapper") IMantenibleMapper<CodigoRazonCobroVisa> mantenibleMapper) {
        super(mantenibleMapper);
        this.codigoRazonCobroVisaMapper = (ICodigoRazonCobroVisaMapper) mantenibleMapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<CodigoRazonCobroVisa> buscarTodosCodigosRazonCobroVisa() {
        return this.codigoRazonCobroVisaMapper.buscarTodos();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public CodigoRazonCobroVisa buscarCodigoRazonCobroVisa(String idCodigoRazon) {
        return this.codigoRazonCobroVisaMapper.buscarCodigoRazonCobroVisa(idCodigoRazon).orElseThrow(
                () -> new RecursoNoEncontradoException(CODIGO_RAZON_NO_ENCONTRADO, idCodigoRazon)
        );
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public CodigoRazonCobroVisa registrarCodigoRazonCobroVisa(CodigoRazonCobroVisa codigoRazonCobroVisa) {
        System.out.println(codigoRazonCobroVisa);
        this.registrar(codigoRazonCobroVisa);
        return this.buscarCodigoRazonCobroVisa(codigoRazonCobroVisa.getIdCodigoRazon());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public CodigoRazonCobroVisa actualizarCodigoRazonCobroVisa(String idCodigoRazon, CodigoRazonCobroVisa codigoRazonCobroVisa) {
        this.actualizar(codigoRazonCobroVisa);
        return this.buscarCodigoRazonCobroVisa(idCodigoRazon);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void eliminarCodigoRazonCobroVisa(String idCodigoRazon) {
        CodigoRazonCobroVisa codigoRazonCobroVisa = CodigoRazonCobroVisa.builder().idCodigoRazon(idCodigoRazon).build();
        this.eliminar(codigoRazonCobroVisa);
    }
}
