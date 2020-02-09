package edu.taller.sisgea.consultasgenerales.mapper;

import edu.taller.sisgea.consultasgenerales.model.facturacionirregularvisa.FacturacionIrregularVisa;
import edu.taller.sisgea.consultasgenerales.model.facturacionirregularvisa.FacturacionIrregularVisa;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IFacturacionIrregularVisaMapper {

    List<FacturacionIrregularVisa> buscarTodos();
}
