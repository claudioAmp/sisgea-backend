package ob.unibanca.sicf.facturacion.mapper;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.model.ParametroMantenimiento;
import ob.unibanca.sicf.facturacion.model.SecuenciaEmision;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface ISecuenciaEmisionMapper extends IMantenibleMapper<SecuenciaEmision> {

    Optional<SecuenciaEmision> buscarSecuenciaEmision(Integer idSecuenciaEmision);
}
