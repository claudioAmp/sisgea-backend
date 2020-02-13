package edu.taller.sisgea.mantenimientosgenerales.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	String dni;
	String nombres;
	String apellidoPaterno;
	String apellidoMaterno;
	String descripcionEstadoSolicitud;
	String tipoSolicitud;
	String descripcionTipoSolicitud;
	String motivo;
	Date fechaRegistro;
	@JsonFormat(pattern="yyyy-MM-dd")
	Date fechaReserva;
	String horaInicio;
	String horaFin;
	String estadoAsistencia;
}
