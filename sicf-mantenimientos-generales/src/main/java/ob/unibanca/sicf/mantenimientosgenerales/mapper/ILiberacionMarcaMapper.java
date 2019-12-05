package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.LiberacionMarca;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ILiberacionMarcaMapper extends IMantenibleMapper<LiberacionMarca> {

    Optional<LiberacionMarca> buscarLiberacionMarca(String idMembresia, Integer Producto,String idProceso);

    List<LiberacionMarca> buscarLiberacionMarcasPorMembresia(String idMembresia);
    
}
