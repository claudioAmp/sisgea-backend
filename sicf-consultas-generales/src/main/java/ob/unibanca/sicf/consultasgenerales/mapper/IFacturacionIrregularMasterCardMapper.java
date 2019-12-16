package ob.unibanca.sicf.consultasgenerales.mapper;

import ob.unibanca.sicf.consultasgenerales.model.facturacionirregularmastercard.FacturacionIrregularMasterCard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IFacturacionIrregularMasterCardMapper {

    List<FacturacionIrregularMasterCard> buscarTodos();
}
