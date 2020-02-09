package edu.taller.sisgea.mantenimientosgenerales.model.trasladoinstituciones;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.spring.validation.validation.BooleanoRequerido;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class DistribucionMcEventos {

    private String secuenciaAgrupada;

    private String eventId;
    private String eventDescription;

    private double rate;

    private double valorTransaccionTotal;

    private int totalUnits;

    @BooleanoRequerido
    private boolean indUnits;

    private Integer idMoneda;
    private String descripcionMoneda;
    private String abreviaturaMoneda;

    private List<DistribucionMcEventosDetalle> listaDistribucion;

}
