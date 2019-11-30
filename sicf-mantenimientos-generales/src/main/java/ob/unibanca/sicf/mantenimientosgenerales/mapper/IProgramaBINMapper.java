package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.ProgramaBIN;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface IProgramaBINMapper  extends IMantenibleMapper<ProgramaBIN> {
    Optional<ProgramaBIN> buscarProgramaBIN(String idMembresia, Integer idProducto, Integer idPrograma);
    List<ProgramaBIN> buscarTodosProgramasBIN();
}
