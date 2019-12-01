package ob.unibanca.sicf.mantenimientosgenerales.service.programabin;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.ProgramaBIN;

import java.util.List;

public interface IProgramaBINService extends IMantenibleService<ProgramaBIN> {

    List<ProgramaBIN> buscarTodosProgramasBin();

    ProgramaBIN buscarProgramaBin(String idMembresia, Integer idProducto, Integer idPrograma);

    ProgramaBIN registrarProgramaBin(ProgramaBIN programaBin);

    ProgramaBIN actualizarProgramaBin(String idMembresia, Integer idProducto, Integer idPrograma, ProgramaBIN programaBin);

    void eliminarProgramaBin(String idMembresia, Integer idProducto, Integer idPrograma);
}
