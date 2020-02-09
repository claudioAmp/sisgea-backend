package edu.taller.sisgea.conciliacion.service.generarconciliacion;

import edu.taller.sisgea.conciliacion.mapper.IGenerarConciliacionMapper;
import edu.taller.sisgea.conciliacion.service.campoactualizar.ICampoActualizarService;
import edu.taller.sisgea.conciliacion.service.campodiferencia.ICampoDiferenciaService;
import edu.taller.sisgea.conciliacion.service.campomatching.ICampoMatchingService;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import edu.taller.sisgea.conciliacion.model.CampoActualizar;
import edu.taller.sisgea.conciliacion.model.CampoDiferencia;
import edu.taller.sisgea.conciliacion.model.CampoInsertarObservada;
import edu.taller.sisgea.conciliacion.model.CampoMatching;
import edu.taller.sisgea.conciliacion.model.GenerarConciliacion;
import edu.taller.sisgea.conciliacion.service.campoinsertarobservada.ICampoInsertarObservadaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GenerarConciliacionService extends MantenibleService<GenerarConciliacion> implements IGenerarConciliacionService {
	
	private final IGenerarConciliacionMapper generarConciliacionMapper;
	private @Autowired
    ICampoMatchingService campoMatchingService;
	private @Autowired
    ICampoDiferenciaService campoDiferenciaService;
	private @Autowired
    ICampoActualizarService campoActualizarService;
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
