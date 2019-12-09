package ob.unibanca.sicf.consultasgenerales.service.facturacionirregularvisa;

import java.util.List;

import ob.unibanca.sicf.consultasgenerales.mapper.IFacturacionIrregularVisaMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ob.unibanca.sicf.consultasgenerales.model.facturacionirregularvisa.FacturacionIrregularVisa;

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
