package edu.taller.sisgea.consultasgenerales.model.irregular;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class IrregularDetalle {
	private String secuencia;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProceso ;
	private String idOrigenArchivo;
	private Integer indRegularizada;
	private String descIdMembresia;
	private String descIdServicio;
	private String descIdOrigen;
	private String descIdClaseTransaccion;
	private String descIdCodigoTransaccion;
	private String descIdCanal;
	private String descIdInstitucionEmisora;
	private String descInstitucionReceptora;
	private String descBIN;
	private String descTransaccionOriginal;      
	private Integer compensaFondos;
	private Integer compensaComisiones;
	private Integer fondoCargo;
	private Integer fondoAbono;
	

}
