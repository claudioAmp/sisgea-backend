package edu.taller.sisgea.mantenimientosgenerales.service.plan;

import ob.commons.mantenimiento.service.IMantenibleService;
import edu.taller.sisgea.mantenimientosgenerales.model.resultadocarga.ResultadoCarga;
import edu.taller.sisgea.mantenimientosgenerales.model.Plan;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface IPlanService extends IMantenibleService<Plan> {
	
	List<Plan> buscarTodosPlan();
	
	Plan buscarPlan(String idPlan);
	
	List<ResultadoCarga> cargarArchivos(List<MultipartFile> multipartfiles);
	
}