package ob.unibanca.sicf.generadorconsultas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TablaOnJoin {
	Integer idTablaOnJoin;
	int idReporte;
	int idCampoQueryBase;
	int idTablaBase;
	String tablaBase;
	String instanciaTablaBase;
	int idCampoBase;
	String campoBase;
	int idCampoQueryJoin;
	int idTablaJoin;
	String tablaJoin;
	String instanciaTablaJoin;
	int idCampoJoin;
	String campoJoin;
	int idOperador;
	String simboloOperador;
	String operadorLogico;
}
