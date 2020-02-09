package edu.taller.sisgea.consultasgenerales.service.facturacionirregularvisa;

import java.util.List;

import edu.taller.sisgea.consultasgenerales.mapper.IFacturacionIrregularVisaMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import edu.taller.sisgea.consultasgenerales.model.facturacionirregularvisa.FacturacionIrregularVisa;

@Service
public class FacturacionIrregularVisaService implements IFacturacionIrregularVisaService {
    
    private final IFacturacionIrregularVisaMapper facturacionIrregularVisaMapper;

    public FacturacionIrregularVisaService(IFacturacionIrregularVisaMapper mantenibleMapper) {
        this.facturacionIrregularVisaMapper = (IFacturacionIrregularVisaMapper) mantenibleMapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<FacturacionIrregularVisa> buscarTodosFacturacionIrregularVisa() {
        return this.facturacionIrregularVisaMapper.buscarTodos();
    }
}
