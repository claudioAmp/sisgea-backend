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
	String aliasTablaBase;
	String instanciaTablaBase;
	int idCampoBase;
	String campoBase;
	String aliasCampoBase;
	int idCampoQueryJoin;
	int idTablaJoin;
	String tablaJoin;
	String aliasTablaJoin;
	String instanciaTablaJoin;
	int idCampoJoin;
	String campoJoin;
	String aliasCampoJoin;
	int idOperador;
	String simboloOperador;
	String operadorLogico;
}
