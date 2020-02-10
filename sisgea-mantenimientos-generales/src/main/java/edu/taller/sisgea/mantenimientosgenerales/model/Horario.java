package edu.taller.sisgea.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Horario {

    private Integer idHorario;
    private String idCurso;
    private Integer seccion;
    private String dia;
    private Date horarioInicio;
    private Date horarioFin;

}
