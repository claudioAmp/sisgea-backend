package edu.taller.sisgea.mantenimientosgenerales.service.docente;

import edu.taller.sisgea.mantenimientosgenerales.mapper.IDocenteMapper;
import edu.taller.sisgea.mantenimientosgenerales.model.Docente;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DocenteService extends MantenibleService<Docente> implements IDocenteService {

    private final IDocenteMapper docenteMapper;

    public DocenteService(@Qualifier("IDocenteMapper")IMantenibleMapper<Docente> mantenibleMapper){
        super(mantenibleMapper);
        this.docenteMapper = (IDocenteMapper) mantenibleMapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Docente> buscarTodosDocentes(){
        return this.buscarTodos();
    }

}
