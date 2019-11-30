package ob.unibanca.sicf.mantenimientosgenerales.service.programabin;

import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.mapper.IProgramaBINMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.ProgramaBIN;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProgramaBinService  extends MantenibleService<ProgramaBIN> implements IProgramaBINService {

    private static final String PROGRAMA_BIN_NO_ENCONTRADO = "No existe  el programa BIN con membresía %s, producto %d y programa %d";
    private final IProgramaBINMapper programaBINMapper;

    public ProgramaBinService(@Qualifier("IProgramaBINMapper") IMantenibleMapper<ProgramaBIN> mantenibleMapper) {
        super(mantenibleMapper);
        this.programaBINMapper = (IProgramaBINMapper) mantenibleMapper;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<ProgramaBIN> buscarTodosProgramasBin() {
        return programaBINMapper.buscarTodos();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public ProgramaBIN buscarProgramaBin(String idMembresia, Integer idProducto, Integer idPrograma) {
        return programaBINMapper.buscarProgramaBIN(idMembresia, idProducto, idPrograma).orElseThrow(
                () -> new RecursoNoEncontradoException(PROGRAMA_BIN_NO_ENCONTRADO, idMembresia, idProducto, idPrograma)
        );
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ProgramaBIN registrarProgramaBin(ProgramaBIN programaBin) {
        this.registrar(programaBin);
        return this.buscarProgramaBin(programaBin.getIdMembresia(), programaBin.getIdProducto(), programaBin.getIdPrograma());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ProgramaBIN actualizarProgramaBin(String idMembresia, Integer idProducto, Integer idPrograma, ProgramaBIN programaBin) {
        // TODO(ids): es necesario colocarlos? no es necesaria una validacion?
        programaBin.setIdMembresia(idMembresia);
        programaBin.setIdProducto(idProducto);
        programaBin.setIdPrograma(idPrograma);
        this.actualizar(programaBin);
        return this.buscarProgramaBin(idMembresia, idProducto, idPrograma);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void eliminarProgramaBin(String idMembresia, Integer idProducto, Integer idPrograma) {
        ProgramaBIN programaBIN = ProgramaBIN.builder()
                .idMembresia(idMembresia)
                .idProducto(idProducto)
                .idPrograma(idPrograma)
                .build();
        this.eliminar(programaBIN);
    }
}
