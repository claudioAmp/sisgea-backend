package edu.taller.sisgea.generadorconsultas.mapper;

import java.util.List;

import edu.taller.sisgea.generadorconsultas.model.PermisoUsuario;
import edu.taller.sisgea.generadorconsultas.model.Tabla;
import edu.taller.sisgea.generadorconsultas.model.criterio.CriterioBusquedaPermisoUsuario;
import org.apache.ibatis.annotations.Mapper;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;

@Mapper
public interface IPermisoUsuarioMapper extends IMantenibleMapper<PermisoUsuario> {
	List<PermisoUsuario> buscarTodos();

	List<PermisoUsuario> buscarPorCriterios(CriterioBusquedaPermisoUsuario criterio);

	void actualizarPermisosUsuario(int idPerfil, String listaModificacion, String usuario);

	List<Tabla> buscarTablasPermitidasUsuario(String username);
}
