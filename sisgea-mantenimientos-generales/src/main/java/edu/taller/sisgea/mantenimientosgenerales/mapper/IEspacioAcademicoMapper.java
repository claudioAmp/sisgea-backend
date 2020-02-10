package edu.taller.sisgea.mantenimientosgenerales.mapper;

import edu.taller.sisgea.mantenimientosgenerales.model.resultadoasignacionespaciosacademicos.ResultadoAsignacionEspaciosAcademicos;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import edu.taller.sisgea.mantenimientosgenerales.model.EspacioAcademico;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface IEspacioAcademicoMapper extends IMantenibleMapper<EspacioAcademico> {
	
	Optional<EspacioAcademico> buscarEspacioAcademico(Integer idEspacioAcademico);

	public void ejecutarProcedimientoAsignacionEspacioAcademico();

	public List<ResultadoAsignacionEspaciosAcademicos> buscarTodosResultados ();
	
}
