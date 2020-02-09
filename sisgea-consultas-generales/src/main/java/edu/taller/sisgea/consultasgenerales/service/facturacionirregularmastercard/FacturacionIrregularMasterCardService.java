package edu.taller.sisgea.consultasgenerales.service.facturacionirregularmastercard;

import edu.taller.sisgea.consultasgenerales.mapper.IFacturacionIrregularMasterCardMapper;
import edu.taller.sisgea.consultasgenerales.model.facturacionirregularmastercard.FacturacionIrregularMasterCard;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FacturacionIrregularMasterCardService implements IFacturacionIrregularMasterCardService{

    private final IFacturacionIrregularMasterCardMapper facturacionIrregularMasterCardMapper;

    public FacturacionIrregularMasterCardService(IFacturacionIrregularMasterCardMapper mantenibleMapper) {
        this.facturacionIrregularMasterCardMapper = (IFacturacionIrregularMasterCardMapper) mantenibleMapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<FacturacionIrregularMasterCard> buscarTodosFacturacionIrregularMasterCard() {
        return this.facturacionIrregularMasterCardMapper.buscarTodos();
    }
}
