package edu.taller.sisgea.reportes.model.control;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReporteControlVSSVisaDetalle {
	Integer idOrigen;
	String descripcionOrigen;
	String idRegion;
	String descripcionRegion;
	String pais;
	String idTransaccionOriginal;
	String descripcionTransaccionOriginal;
	Integer transaccionCuasiCash;
	String idProgramaComision;
	String descripcionProgramaComision;
	Integer monedaCompensacion;
	String descripcionMonedaCompensacion;
	Integer cantidad;
	Double totalFondos;
	Double totalEst;
	Double totalInt;
	Double totalIsa;
	Double totalOif;
}

