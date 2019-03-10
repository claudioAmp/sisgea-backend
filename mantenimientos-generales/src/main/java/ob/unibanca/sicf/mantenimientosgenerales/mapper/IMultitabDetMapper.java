package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.MultitabDet;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface IMultitabDetMapper extends IMantenibleMapper<MultitabDet> {

	Optional<MultitabDet> buscarUno(int idMultitabCab, String idMultitabDet);
	
	List<MultitabDet> buscarMultitabsDetMultitabCab(int idMultitabCab);
}
