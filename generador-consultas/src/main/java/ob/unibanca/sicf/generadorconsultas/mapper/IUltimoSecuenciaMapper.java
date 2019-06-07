package ob.unibanca.sicf.generadorconsultas.mapper;


import org.apache.ibatis.annotations.Mapper;
import ob.unibanca.sicf.generadorconsultas.model.UltimoSecuencia;


@Mapper
public interface IUltimoSecuenciaMapper {
	void obtenerUltimoSecuencia(UltimoSecuencia ultimoSecuencia);
	
}
