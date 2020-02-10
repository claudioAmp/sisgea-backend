package edu.taller.sisgea.mantenimientosgenerales.service.horario;

import edu.taller.sisgea.mantenimientosgenerales.model.Horario;
import edu.taller.sisgea.mantenimientosgenerales.model.resultadocarga.ResultadoCarga;
import ob.commons.mantenimiento.service.IMantenibleService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IHorarioService extends IMantenibleService<Horario> {

    List<Horario> buscarTodosHorario();

    Horario buscarHorario(Integer idHorario, String idCurso, Integer seccion);

    List<ResultadoCarga> cargarArchivos(List<MultipartFile> multipartFiles);

}
