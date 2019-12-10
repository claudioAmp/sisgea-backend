package ob.unibanca.sicf.mantenimientosgenerales.service.codigorazoncobrovisa;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.CodigoRazonCobroVisa;

import java.util.List;

public interface ICodigoRazonCobroVisaService extends IMantenibleService<CodigoRazonCobroVisa> {
    
    List<CodigoRazonCobroVisa> buscarTodosCodigosRazonCobroVisa();
    
    CodigoRazonCobroVisa buscarCodigoRazonCobroVisa(String idCodigoRazon);

    CodigoRazonCobroVisa registrarCodigoRazonCobroVisa(CodigoRazonCobroVisa codigoRazonCobroVisa);
    
    CodigoRazonCobroVisa actualizarCodigoRazonCobroVisa(String idCodigoRazon, CodigoRazonCobroVisa codigoRazonCobroVisa);
    
    void eliminarCodigoRazonCobroVisa(String idCodigoRazon);
}
