package edu.taller.sisgea.mantenimientosgenerales.model.resultadoasignacionespaciosacademicos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultadoAsignacionEspaciosAcademicos {

    private String periodo;
    private Integer ciclo;
    private String curso;
    private Integer seccion;
    private Integer idDocente;
    private String nombresDocente;
    private String apellidosDocente;
    private Integer tope;
    private Integer matriculados;
    private String turno;
    private String tipoHorario;
    private String dia;
    private Date horaInicio;
    private Date horaFin;
    private String espacio;



}
