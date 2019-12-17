package ob.unibanca.sicf.consultasgenerales.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.criterio.facturamastercard.CriterioBusquedaFacturaMasterCard;
import ob.unibanca.sicf.consultasgenerales.model.facturamastercard.FacturaMasterCard;

@Mapper
public interface IFacturaMasterCardMapper {
	public Page<FacturaMasterCard> buscarPorCriterios(CriterioBusquedaFacturaMasterCard criterioPaginacion);

}
