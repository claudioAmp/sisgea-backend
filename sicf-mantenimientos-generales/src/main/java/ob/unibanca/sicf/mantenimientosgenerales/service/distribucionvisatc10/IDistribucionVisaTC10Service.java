package ob.unibanca.sicf.mantenimientosgenerales.service.distribucionvisatc10;

import ob.unibanca.sicf.mantenimientosgenerales.model.trasladoinstituciones.DistribucionVisaTC10;

import java.util.List;

public interface IDistribucionVisaTC10Service {

    List<DistribucionVisaTC10> buscarRegistrosDistribucionVisaTC10();

    DistribucionVisaTC10 buscarRegistroDistribucionVisaTC10(String secuenciaAgrupada);

    void eliminarDistribucionVisaTC10(String secuenciaAgrupada);

    DistribucionVisaTC10 actualizarDistribucionVisaTC10(String secuenciaAgrupada, DistribucionVisaTC10 DistribucionVisaTC10);

}
