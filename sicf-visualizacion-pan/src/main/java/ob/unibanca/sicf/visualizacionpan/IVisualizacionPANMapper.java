package ob.unibanca.sicf.visualizacionpan;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IVisualizacionPANMapper {
	
	boolean puedeVisualizarPAN(String username, String codigoAudiencia);
}
