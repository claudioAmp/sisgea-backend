package ob.unibanca.sicf.tarifarios.service.tarifarioVISA;

import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.tarifarios.mapper.ITarifarioVISAMapper;
import ob.unibanca.sicf.tarifarios.model.TarifarioVISA;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class TarifarioVISAService extends MantenibleService<TarifarioVISA> implements ITarifarioVISAService {

    private static final String TARIFARIO_VISA_NO_ENCONTRADO = "El Tarifario Emisor %s no existe";
    private final ITarifarioVISAMapper tarifarioVISAMapper;

    public TarifarioVISAService(@Qualifier("ITarifarioVISAMapper") IMantenibleMapper<TarifarioVISA> mantenibleMapper) {
        super(mantenibleMapper);
        this.tarifarioVISAMapper = (ITarifarioVISAMapper) mantenibleMapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<TarifarioVISA> buscarTodosTarifariosVISA() {
        return this.buscarTodos();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public TarifarioVISA buscarTarifarioVISA(int idTarifarioVISA) {
        return this.tarifarioVISAMapper.buscarTarifarioVISA(idTarifarioVISA).orElseThrow(
                () -> new RecursoNoEncontradoException(TARIFARIO_VISA_NO_ENCONTRADO, idTarifarioVISA));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public TarifarioVISA registrarTarifarioVISA(TarifarioVISA tarifarioVISA) {
        this.registrar(tarifarioVISA);
        return this.buscarTarifarioVISA(tarifarioVISA.getIdTarifarioVISA());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public TarifarioVISA actualizarTarifarioVISA(int idTarifarioVISA, TarifarioVISA tarifarioVISA) {
        tarifarioVISA.setIdTarifarioVISA(idTarifarioVISA);
        this.actualizar(tarifarioVISA);
        return this.buscarTarifarioVISA(tarifarioVISA.getIdTarifarioVISA());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void eliminarTarifarioVISA(int idTarifarioVISA) {
        TarifarioVISA tarifarioVISA = TarifarioVISA.builder().idTarifarioVISA(idTarifarioVISA).build();
        this.eliminar(tarifarioVISA);
    }

}
