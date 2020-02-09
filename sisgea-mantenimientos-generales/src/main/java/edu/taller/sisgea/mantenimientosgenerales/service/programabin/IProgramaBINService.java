package edu.taller.sisgea.mantenimientosgenerales.service.programabin;

import ob.commons.mantenimiento.service.IMantenibleService;
import edu.taller.sisgea.mantenimientosgenerales.model.ProgramaBIN;

import java.util.List;

public interface IProgramaBINService extends IMantenibleService<ProgramaBIN> {

    List<ProgramaBIN> buscarTodosProgramasBin();

    ProgramaBIN buscarProgramaBin(String idMembresia, Integer idProducto, Integer idPrograma);

    ProgramaBIN registrarProgramaBin(ProgramaBIN programaBin);

    ProgramaBIN actualizarProgramaBin(String idMembresia, Integer idProducto, Integer idPrograma, ProgramaBIN programaBin);

    void eliminarProgramaBin(String idMembresia, Integer idProducto, Integer idPrograma);

    List<ProgramaBIN> buscarProgramasBinPorMembresiaYProducto(String idMembresia, Integer idProducto);
}
