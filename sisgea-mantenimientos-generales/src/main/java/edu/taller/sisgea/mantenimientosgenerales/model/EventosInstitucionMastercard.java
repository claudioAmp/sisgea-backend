package edu.taller.sisgea.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventosInstitucionMastercard {
	String idEventoMc;
	String description;
	Integer idInstitucion;
	String descripcionInstitucion;
	//Comodin para registro masivo
	String eventosSeparadosPorComas;
	//Vista
	Integer idClaseTransaccion;
	String descripcionClaseTransaccion;
	Integer idCodigoTransaccion;
	String descripcionCodigoTransaccion;
}
