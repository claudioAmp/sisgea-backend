package edu.taller.sisgea.mantenimientosgenerales.model.trasladoinstituciones;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.spring.validation.validation.BooleanoRequerido;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DistribucionVisaEventos {

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
    
    private List<DistribucionVisaEventosDetalle> listaDistribucion;

}
