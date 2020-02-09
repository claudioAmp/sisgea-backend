package edu.taller.sisgea.mantenimientosgenerales.service.reglascompensacion;

import java.util.List;

import edu.taller.sisgea.mantenimientosgenerales.model.ReglasCompensacion;

public interface IReglasCompensacionService{
	
	List<ReglasCompensacion> buscarTodos();
	
	List<ReglasCompensacion> buscarPorId(Integer idReglasCompensacion);
	
	public ReglasCompensacion registrarReglaCompensacion(ReglasCompensacion reglasCompensacion);
	
	public ReglasCompensacion actualizarReglaCompensacion(ReglasCompensacion reglasCompensacion);
	
	public void eliminarReglaCompensacion(ReglasCompensacion reglasCompensacion);
}
