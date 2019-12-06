package ob.unibanca.sicf.mantenimientosgenerales.service.reglascompensacion;

import java.util.List;
import ob.unibanca.sicf.mantenimientosgenerales.model.ReglasCompensacion;

public interface IReglasCompensacionService{
	
	List<ReglasCompensacion> buscarTodos();
	
	List<ReglasCompensacion> buscarPorId(Integer idReglasCompensacion);
	
	public ReglasCompensacion registrarReglaCompensacion(ReglasCompensacion reglasCompensacion);
	
	public ReglasCompensacion actualizarReglaCompensacion(ReglasCompensacion reglasCompensacion);
	
	public void eliminarReglaCompensacion(ReglasCompensacion reglasCompensacion);
}
