package edu.taller.sisgea.mantenimientosgenerales.service.modoentradapos;

import ob.commons.mantenimiento.service.IMantenibleService;
import edu.taller.sisgea.mantenimientosgenerales.model.ModoEntradaPOS;

import java.util.List;

public interface IModoEntradaPOSService extends IMantenibleService<ModoEntradaPOS> {
	
	List<ModoEntradaPOS> buscarTodosModosEntradasPOS();
	
	List<ModoEntradaPOS> buscarModosEntradasPOSPorMembresia(String idMembresia);
	
	ModoEntradaPOS buscarModoEntradaPOS(String idMembresia, String idModoEntradaPOS);
	
	ModoEntradaPOS registrarModoEntradaPOS(String idMembresia, ModoEntradaPOS modoEntradaPOS);
	
	ModoEntradaPOS actualizarModoEntradaPOS(String idMembresia, String idModoEntradaPOS, ModoEntradaPOS modoEntradaPOS);
	
	void eliminarModoEntradaPOS(String idMembresia, String idModoEntradaPOS);
}