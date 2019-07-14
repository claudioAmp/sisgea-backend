package ob.unibanca.sicf.generadorconsultas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Filtro {
	Integer idFiltroCampo;
	int idCampoQuery;
	int idReporte;
	int idTabla;
	String tabla;
	int idCampo;
	String campo;
	String idInstancia;
	int idOperador;
	String simboloOperador;
	int idCondicionPadre;
	String valor;
	String tipoDatoValor;
	int permitido;

}
