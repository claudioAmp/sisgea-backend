package ob.unibanca.sicf.consultasgenerales.service.establecimientodcp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import ob.unibanca.sicf.consultasgenerales.mapper.IEstablecimientoDcpMapper;
import ob.unibanca.sicf.consultasgenerales.model.criterio.establecimientodcp.CriterioBusquedaEstablecimientoDcp;
import ob.unibanca.sicf.consultasgenerales.model.establecimientodcp.EstablecimientoDcp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstablecimientoDcpService implements IEstablecimientoDcpService {

    private final IEstablecimientoDcpMapper establecimientoDcpMapper;

    public EstablecimientoDcpService(IEstablecimientoDcpMapper establecimientoDcpMapper)
    {
        this.establecimientoDcpMapper = establecimientoDcpMapper;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Page<EstablecimientoDcp> buscarPorCriterios(CriterioBusquedaEstablecimientoDcp criterioPaginacion, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return establecimientoDcpMapper.buscarPorCriterios(criterioPaginacion);
    }
}
