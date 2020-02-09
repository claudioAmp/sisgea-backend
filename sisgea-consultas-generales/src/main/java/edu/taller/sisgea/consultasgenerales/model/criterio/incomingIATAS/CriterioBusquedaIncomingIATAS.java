package edu.taller.sisgea.consultasgenerales.model.criterio.incomingIATAS;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaIncomingIATAS {
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date 		fechaProcesoInicio;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date 		fechaProcesoFin;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date 		fechaProceso;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date		fechaConsumoInicio;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date		fechaConsumoFin;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date		fechaConsumo;
	private String		numeroTarjeta;
	
	//filtros
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date 		filtroFechaProceso;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date		filtroFechaConsumo;
	private Long 		filtroIdIatas;
	private String		filtroNumeroTarjeta;
	private String 		filtroCodigoAutorizacion;
	private String		filtroCodigoEstablecimiento;
	private String		filtroTipoDocumento;
	private String 		filtroNumeroDocumento;
	private String		filtroAutorizacionFee;
	
	//ordenamiento
	private String 		ordenFechaProceso;
	private String		ordenFechaConsumo;
	private String		ordenNumeroTarjeta;
	private String 		ordenCodigoAutorizacion;
	private String		ordenCodigoEstablecimiento;
	private String		ordenImporteTransaccion;
	private String		ordenNumeroCuotas;
	private String 		ordenNumeroMesesDiferido;
	private String		ordenTipoDocumento;
	private String 		ordenNumeroDocumento;
	private String		ordenAutorizacionFee;
	private String 		ordenIdIatas;
	
	
	//criterio de filtro de encabezado aggrid rango de importe
	private Double 		rangoImporteTransaccionMin;
	private Double 		rangoImporteTransaccionMax;
	private Integer		rangoNumeroCuotasMin;
	private Integer		rangonumeroCuotasMax;
	private Integer		rangoNumeroMesesDiferidoMin;
	private Integer		rangoNumeroMesesDiferidoMax;
}
