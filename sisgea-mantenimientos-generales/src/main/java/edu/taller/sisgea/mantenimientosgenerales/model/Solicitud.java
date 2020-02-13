package edu.taller.sisgea.mantenimientosgenerales.model;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Solicitud {
	Integer idSolicitud;
	Integer idEspacioAcademico;
	String descripcionEspacioAcademico;
	Integer idSolicitante;
	String estadoSolicitud;
	String descripcionEstadoSolicitud;
	String tipoSolicitud;
	String descripcionTipoSolicitud;
	String motivo;
	Date fechaRegistro;
	Date fechaReserva;
	String horaInicio;
	String horaFin;
	String estadoAsistencia;
}
