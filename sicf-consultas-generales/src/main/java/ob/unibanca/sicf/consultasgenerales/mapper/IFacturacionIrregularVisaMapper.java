package ob.unibanca.sicf.consultasgenerales.mapper;

import ob.unibanca.sicf.consultasgenerales.model.facturacionirregularvisa.FacturacionIrregularVisa;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IFacturacionIrregularVisaMapper {

    List<FacturacionIrregularVisa> buscarTodos();
}
