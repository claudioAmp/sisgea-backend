package edu.taller.sisgea.consultasgenerales.mapper.solicitud;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import edu.taller.sisgea.consultasgenerales.model.solicitud.Solicitud;

@Mapper
public interface ISolicitudMapper {
	
	List<Solicitud> buscarTodosSolictud();
	
	Optional<Solicitud> buscarSolicitud(Integer idSolicitud);
	
	Solicitud registrarSolicitud(Solicitud solicitud);
	
	Solicitud actualizarSolicitud(Integer idSolicitud);
	
	void eliminarSolicitud(Integer idSolicitud);
}
