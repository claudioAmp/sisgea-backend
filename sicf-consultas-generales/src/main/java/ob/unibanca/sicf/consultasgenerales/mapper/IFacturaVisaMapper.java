package ob.unibanca.sicf.consultasgenerales.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;
import ob.unibanca.sicf.consultasgenerales.model.criterio.facturavisa.CriterioBusquedaFacturaVisa;
import ob.unibanca.sicf.facturacion.model.FacturaVisa;

@Mapper
public interface IFacturaVisaMapper {
	
	public Page<FacturaVisa> buscarPorCriterios(CriterioBusquedaFacturaVisa criterioPaginacion);

}
