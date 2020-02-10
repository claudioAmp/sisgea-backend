package edu.taller.sisgea.mantenimientosgenerales.service.curso;

import edu.taller.sisgea.mantenimientosgenerales.model.Curso;
import edu.taller.sisgea.mantenimientosgenerales.model.resultadocarga.ResultadoCarga;
import ob.commons.mantenimiento.service.IMantenibleService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ICursoService extends IMantenibleService<Curso> {

    List<Curso> buscarTodosCursos();

    Curso buscarCurso (String idCurso);

    List<ResultadoCarga> cargaArchivos(List<MultipartFile> multipartfiles);

}
