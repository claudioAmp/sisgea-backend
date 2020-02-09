package edu.taller.sisgea.consultasgenerales.service.irregular;


import com.github.pagehelper.Page;
import edu.taller.sisgea.consultasgenerales.model.criterio.irregular.CriterioBusquedaIrregular;
import edu.taller.sisgea.consultasgenerales.model.irregular.Irregular;


public interface IIrregularService {


	public Page<Irregular> buscarPorCriteriosIrregulares(CriterioBusquedaIrregular criterio , int pageNo, int pageSize);
}
