package edu.taller.sisgea.consultasgenerales.mapper;

import edu.taller.sisgea.consultasgenerales.model.facturacionirregularmastercard.FacturacionIrregularMasterCard;
import edu.taller.sisgea.consultasgenerales.model.facturacionirregularmastercard.FacturacionIrregularMasterCard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IFacturacionIrregularMasterCardMapper {

    List<FacturacionIrregularMasterCard> buscarTodos();
}
