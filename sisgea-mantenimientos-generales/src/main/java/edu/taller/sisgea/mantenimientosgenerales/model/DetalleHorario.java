package edu.taller.sisgea.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetalleHorario {

    private Integer idHorarioDetalle;
    private String idCurso;
    private Integer seccion;
    private Integer idHorario;
    private String tipoHorario;
    private String horarioInicio;
    private String horarioFin;

}
