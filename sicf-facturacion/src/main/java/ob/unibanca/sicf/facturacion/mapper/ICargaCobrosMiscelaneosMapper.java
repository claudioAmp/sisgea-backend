package ob.unibanca.sicf.facturacion.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.Map;

@Mapper
public interface ICargaCobrosMiscelaneosMapper {

   void cargarRegistro(Map<String, Object> params);
   
}
