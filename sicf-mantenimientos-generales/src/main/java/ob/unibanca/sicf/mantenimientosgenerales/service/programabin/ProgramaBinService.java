package ob.unibanca.sicf.mantenimientosgenerales.service.programabin;

import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.ProgramaBIN;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramaBinService  extends MantenibleService<ProgramaBIN> implements IProgramaBINService {

    @Override
    public List<ProgramaBIN> buscarTodosProgramasBin() {
        return null;
    }

    @Override
    public ProgramaBIN buscarProgramaBin(String idMembresia, Integer idProducto, Integer idPrograma) {
        return null;
    }

    @Override
    public ProgramaBIN registrarProgramaBin(ProgramaBIN programaBin) {
        return null;
    }

    @Override
    public ProgramaBIN actualizarProgramaBin(String idMembresia, Integer idProducto, Integer idPrograma, ProgramaBIN programaBin) {
        return null;
    }

    @Override
    public void eliminarProgramaBin(String idMembresia, Integer idProducto, Integer idPrograma) {

    }
}
