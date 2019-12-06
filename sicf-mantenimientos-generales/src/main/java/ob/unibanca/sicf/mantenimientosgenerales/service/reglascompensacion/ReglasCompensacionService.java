package ob.unibanca.sicf.mantenimientosgenerales.service.reglascompensacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.mapper.IReglasCompensacionMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.DistribucionComision;
import ob.unibanca.sicf.mantenimientosgenerales.model.DistribucionFondo;
import ob.unibanca.sicf.mantenimientosgenerales.model.ReglasCompensacion;
import ob.unibanca.sicf.mantenimientosgenerales.service.distribucionfondo.IDistribucionFondoService;
import ob.unibanca.sicf.mantenimientosgenerales.service.distribucioncomision.IDistribucionComisionService;

@Service
public class ReglasCompensacionService extends MantenibleService<ReglasCompensacion> implements IReglasCompensacionService {
	
	private static final String REGLA_COMPENSACION_NO_ENCONTRADO = "La regla de compensación %s no existe";
	private final IReglasCompensacionMapper reglasCompensacionMapper;
	private IDistribucionFondoService distribucionFondoService;
	private IDistribucionComisionService distribucionComisionService;
	
	public ReglasCompensacionService(@Qualifier("IReglasCompensacionMapper") IMantenibleMapper<ReglasCompensacion> mantenibleMapper) {
		super(mantenibleMapper);
		this.reglasCompensacionMapper = (IReglasCompensacionMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<ReglasCompensacion> buscarTodos(){
		return this.reglasCompensacionMapper.buscarTodos();
	}
	
		
	@Transactional(propagation = Propagation.REQUIRED)
	public ReglasCompensacion registrarReglaCompensacion(ReglasCompensacion reglasCompensacion){
		DistribucionFondo distribucionFondo = DistribucionFondo.builder()
					.idMembresia(reglasCompensacion.getIdMembresia())
					.idServicio(reglasCompensacion.getIdServicio())
					.idOrigen(reglasCompensacion.getIdOrigen())
					.idClaseTransaccion(reglasCompensacion.getIdClaseTransaccion())
					.idCodigoTransaccion(reglasCompensacion.getIdCodigoTransaccion())
					.idCuentaCargo(reglasCompensacion.getIdCuentaCargoFondo())
					.idCuentaAbono(reglasCompensacion.getIdCuentaAbonoFondo())
					.build();
		distribucionFondo = distribucionFondoService.registrarDistribucionComision(distribucionFondo);
		reglasCompensacion.getComisiones().forEach((comision) ->{
			DistribucionComision distribucionComision = DistribucionComision.builder()
					.idMembresia(reglasCompensacion.getIdMembresia())
					.idServicio(reglasCompensacion.getIdServicio())
					.idOrigen(reglasCompensacion.getIdOrigen())
					.idClaseTransaccion(reglasCompensacion.getIdClaseTransaccion())
					.idCodigoTransaccion(reglasCompensacion.getIdCodigoTransaccion())
					.idCuentaCargo(comision.getIdCuentaCargoComision())
					.idCuentaAbono(comision.getIdCuentaAbonoComision())
					.idTipoComision(comision.getIdTipoComision())
					.build();
			distribucionComisionService.registrar(distribucionComision);
		});
		return this.buscarUno(reglasCompensacion).get();
	}
	
	/*@Transactional(propagation = Propagation.REQUIRED)
	public ReglasCompensacion actualizarReglaCompensacion(ReglasCompensacion reglasCompensacion){
		DistribucionFondo distribucionFondo = DistribucionFondo.builder()
					.idMembresia(reglasCompensacion.getIdMembresia())
					.idServicio(reglasCompensacion.getIdServicio())
					.idOrigen(reglasCompensacion.getIdOrigen())
					.idClaseTransaccion(reglasCompensacion.getIdClaseTransaccion())
					.idCodigoTransaccion(reglasCompensacion.getIdCodigoTransaccion())
					.idCuentaCargo(reglasCompensacion.getIdCuentaCargoFondo())
					.idCuentaAbono(reglasCompensacion.getIdCuentaAbonoFondo())
					.build();
		distribucionFondoService.registrar(distribucionFondo);
		if(!reglasCompensacion.getComisiones().isEmpty()) {
			reglasCompensacion.getComisiones().forEach((comision) ->{
				DistribucionComision distribucionComision = DistribucionComision.builder()
						.idMembresia(reglasCompensacion.getIdMembresia())
						.idServicio(reglasCompensacion.getIdServicio())
						.idOrigen(reglasCompensacion.getIdOrigen())
						.idClaseTransaccion(reglasCompensacion.getIdClaseTransaccion())
						.idCodigoTransaccion(reglasCompensacion.getIdCodigoTransaccion())
						.idCuentaCargo(comision.getIdCuentaCargoComision())
						.idCuentaAbono(comision.getIdCuentaAbonoComision())
						.idTipoComision(comision.getIdTipoComision())
						.build();
				distribucionComisionService.registrar(distribucionComision);
			});
		}
		return this.buscarUno(distribucionFondo.get).get();
	}*/
	
}
