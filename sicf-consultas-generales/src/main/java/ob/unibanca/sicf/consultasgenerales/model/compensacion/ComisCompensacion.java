package ob.unibanca.sicf.consultasgenerales.model.compensacion;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComisCompensacion {
	String idSecuencia;
	Date fechaProceso;
	Integer idComision;
	String descripcionComision;
	Integer idCuentaCompensacion;
	String descIdCuentaCompensacion;
	String registroContable;
	String descRegistroContable;
	Double valorComision;
	Integer nivelTarifario;
	Double tarifaFlat;
	Double tarifaPorcentual;
	Integer aplicaTarifaFlat;
	Integer aplicaTarifaPorcentual;
	Integer idMonedaTarifario;
	Long contadorTxn;
	Integer aplicaIgv;
	Double igvAplicacionTarifa;
	Integer aplicaGrupoBin;
	Integer idGrupoBin;
	Integer infTarifaEmisor;
	String descMonedaTarifario;
	String indicadorCompensacion;
	String descIndicadorCompensacion;
	Integer compensaComisiones;
	Long tipoCambioAplicado;
	Integer idMonedaCompensacion;
	String descMonedaCompensacion;
	
}
