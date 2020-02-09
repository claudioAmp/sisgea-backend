package edu.taller.sisgea.mantenimientosgenerales.mapper;

import edu.taller.sisgea.mantenimientosgenerales.model.trasladoinstituciones.DistribucionVisaTC10;
import edu.taller.sisgea.mantenimientosgenerales.model.trasladoinstituciones.DistribucionVisaTC10Detalle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface IDistribucionVisaTC10Mapper {

    List<DistribucionVisaTC10> buscarRegistrosDistribucionVisaTC10();

    Optional<DistribucionVisaTC10> buscarRegistroDistribucionVisaTC10(String secuenciaAgrupada);

    void eliminarDistribucionVisaTC10(String secuenciaAgrupada);

    void registrarDistribucionVisaTC10(DistribucionVisaTC10Detalle DistribucionVisaTC10);
}
