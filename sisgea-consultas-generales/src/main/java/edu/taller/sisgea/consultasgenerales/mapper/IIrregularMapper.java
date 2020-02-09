package edu.taller.sisgea.consultasgenerales.mapper;

import edu.taller.sisgea.consultasgenerales.model.irregular.Irregular;
import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;
import edu.taller.sisgea.consultasgenerales.model.criterio.irregular.CriterioBusquedaIrregular;
import edu.taller.sisgea.consultasgenerales.model.irregular.Irregular;

@Mapper
public interface IIrregularMapper {


	public Page<Irregular> buscarPorCriteriosIrregulares(CriterioBusquedaIrregular criterio);

}
