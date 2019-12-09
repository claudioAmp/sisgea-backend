package ob.unibanca.sicf.conciliacion.service.generarconciliacion;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.conciliacion.mapper.IGenerarConciliacionMapper;
import ob.unibanca.sicf.conciliacion.model.CampoActualizar;
import ob.unibanca.sicf.conciliacion.model.CampoDiferencia;
import ob.unibanca.sicf.conciliacion.model.CampoInsertarObservada;
import ob.unibanca.sicf.conciliacion.model.CampoMatching;
import ob.unibanca.sicf.conciliacion.model.GenerarConciliacion;
import ob.unibanca.sicf.conciliacion.service.campoactualizar.ICampoActualizarService;
import ob.unibanca.sicf.conciliacion.service.campodiferencia.ICampoDiferenciaService;
import ob.unibanca.sicf.conciliacion.service.campoinsertarobservada.ICampoInsertarObservadaService;
import ob.unibanca.sicf.conciliacion.service.campomatching.ICampoMatchingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GenerarConciliacionService extends MantenibleService<GenerarConciliacion> implements IGenerarConciliacionService {
	
	private final IGenerarConciliacionMapper generarConciliacionMapper;
	private @Autowired ICampoMatchingService campoMatchingService;
	private @Autowired ICampoDiferenciaService campoDiferenciaService;
	private @Autowired ICampoActualizarService campoActualizarService;
	private @Autowired ICampoInsertarObservadaService campoInsertarObservadaService;
	
	public GenerarConciliacionService(@Qualifier("IGenerarConciliacionMapper") IMantenibleMapper<GenerarConciliacion> mantenibleMapper) {
		super(mantenibleMapper);
		this.generarConciliacionMapper = (IGenerarConciliacionMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<GenerarConciliacion> buscarTodosGenerarConciliacions() {
		return this.buscarTodos();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<GenerarConciliacion> buscarCamposTablaObservada() {
		return this.generarConciliacionMapper.buscarCamposTablaObservada();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public GenerarConciliacion buscarPorIdConcTabla(Integer idConcTabla) {
		return this.generarConciliacionMapper.buscarPorIdConcTabla(idConcTabla);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GenerarConciliacion generarConciliacion(GenerarConciliacion generarConciliacion){
		generarConciliacion.getCamposMatching().forEach((campoMat) ->{
			CampoMatching campoMatching = CampoMatching.builder()
					.idConcTabla(generarConciliacion.getIdConcTabla())
					.campoArchivoConcA(campoMat.getCampoArchivoConcA())
					.campoArchivoConcB(campoMat.getCampoArchivoConcB())
					.tipoRango(campoMat.getTipoRango())
					.rangoLimInferior(campoMat.getRangoLimInferior())
					.rangoLimSuperior(campoMat.getRangoLimSuperior())
					.build();
			campoMatchingService.registrarCampoMatching(generarConciliacion.getIdConcTabla(), campoMatching);
		});
		generarConciliacion.getCamposDiferencia().forEach((campoDif)->{
			CampoDiferencia campoDiferencia = CampoDiferencia.builder()
					.idConcTabla(generarConciliacion.getIdConcTabla())
					.campoObservadoConc(campoDif.getCampoObservadoConc())
					.campoObservadoDes(campoDif.getCampoObservadoDes())
					.respCodeConc(campoDif.getRespCodeConc())
					.build();
			campoDiferenciaService.registrarCampoDiferencia(generarConciliacion.getIdConcTabla(), campoDiferencia);
		});
		generarConciliacion.getCamposActualizar().forEach((campoAct)->{
			CampoActualizar campoActualizar = CampoActualizar.builder()
					.idConcTabla(generarConciliacion.getIdConcTabla())
					.idTablaCampoAct(campoAct.getIdTablaCampoAct())//generarConciliacion.getIdArchivoConciliarA()
					.idTablaCampoRef(campoAct.getIdTablaCampoRef())//generarConciliacion.getIdArchivoConciliarB()
					.campoActualizar(campoAct.getCampoActualizar())
					.campoReferencia(campoAct.getCampoReferencia())
					.aplicaExpresion(campoAct.getAplicaExpresion())
					.build();
			campoActualizarService.registrarCampoActualizar(generarConciliacion.getIdConcTabla(), campoActualizar);
		});
		generarConciliacion.getCamposInsertarObservada().forEach((campoInsObs)->{
			CampoInsertarObservada campoInsertarObservada = CampoInsertarObservada.builder()
					.idConcTabla(generarConciliacion.getIdConcTabla())
					.campoTxnObservada(campoInsObs.getCampoTxnObservada())
					.campoInsertar(campoInsObs.getCampoInsertar())
					.idOrigenArchivo(campoInsObs.getIdOrigenArchivo())
					.build();
			campoInsertarObservadaService.registrarCampoInsertarObservada(generarConciliacion.getIdConcTabla(), campoInsertarObservada);
		});
		return this.generarConciliacionMapper.buscarPorIdConcTabla(generarConciliacion.getIdConcTabla());
	}
}
