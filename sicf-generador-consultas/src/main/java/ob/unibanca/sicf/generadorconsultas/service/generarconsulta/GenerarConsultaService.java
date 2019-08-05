package ob.unibanca.sicf.generadorconsultas.service.generarconsulta;

import ob.unibanca.sicf.generadorconsultas.model.CampoQuery;
import ob.unibanca.sicf.generadorconsultas.model.CondicionQuery;
import ob.unibanca.sicf.generadorconsultas.model.Filtro;
import ob.unibanca.sicf.generadorconsultas.model.Reporte;
import ob.unibanca.sicf.generadorconsultas.model.TablaOnJoin;
import ob.unibanca.sicf.generadorconsultas.model.TablaQuery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class GenerarConsultaService implements IGenerarConsultaService {

	@Override
	public String generarConsulta(Reporte reporteEstado) {
		// CambiosParaGenerateQuery
		Map<String, Integer> a = new HashMap<>();
		String queryReporte;
		queryReporte = "SELECT ";
		queryReporte += this.getOnSelect(reporteEstado, a);
		queryReporte += " FROM ";
		queryReporte += this.getOnFrom(reporteEstado);
		queryReporte += " ";
		queryReporte += this.getOnWhere(reporteEstado);
		queryReporte += " ";
		queryReporte += this.getOnGroupBy(reporteEstado);
		queryReporte += " ";
		queryReporte += this.getOnHaving(reporteEstado);
		queryReporte += " ";
		queryReporte += this.getOnOrderBy(reporteEstado);
		return queryReporte;
	}

	String getOnSelect(Reporte reporteEstado, Map<String, Integer> a) {
		String query = "";
		boolean flagFirst = true;
		for (CampoQuery campo : reporteEstado.getCampos()) {
			if (campo.isEnSelect()) {
				// Logica para colocar en el query
				if (flagFirst) {
					query += " ";
					flagFirst = false;
				} else {
					query += ", ";
				}
				if (campo.getFuncionGrupo() != null) {
					query += campo.getFuncionGrupo() + "(" + campo.getIdInstanciaTabla() + "." + campo.getCampo() + ")";
				} else {
					if(campo.getTruncable()==0) {
						query += campo.getIdInstanciaTabla() + "." + campo.getCampo();
					}else {
						if(reporteEstado.isVisualiza()) {
							query += campo.getIdInstanciaTabla() + "." + campo.getCampo();
						} else {
							query += this.formatTrunc(campo.getIdInstanciaTabla() + "." + campo.getCampo());
						}
					}
				}
				query += " AS " + "\"" + campo.getAliasEnQuery() + "\"";
			}
		}
		return query;
	}

	String formatTrunc(String nombreCampo) {
		return "CONCAT(CONCAT(substr("+nombreCampo+",1,6),rpad('*',length("+nombreCampo+")-10,'*')),substr("+nombreCampo+",length("+nombreCampo+")-3,length("+nombreCampo+")))";
	}
	
	String getOnFrom(Reporte reporteEstado) {
		String query = "";
		boolean flagFrom = true;
		List<TablaQuery> aux = reporteEstado.getTablas();
		aux.sort(new Comparator<TablaQuery>() {
			@Override
			public int compare(TablaQuery o1, TablaQuery o2) {
				return Integer.valueOf(o1.getOrden()).compareTo(Integer.valueOf(o2.getOrden()));
			}
		});
		System.out.println(aux);
		reporteEstado.setTablas(aux);
		if (reporteEstado.getTablas().size() == 1) {
			TablaQuery tabla = reporteEstado.getTablas().get(0);
			query += tabla.getTabla() + " " + tabla.getIdInstancia();
		} else {
			for (TablaQuery tabla : reporteEstado.getTablas()) {
				if (flagFrom) {
					query += tabla.getTabla() + " " + tabla.getIdInstancia();
					flagFrom = false;
				} else {
					query += " " + tabla.getTipoJoin() + " " + tabla.getTabla() + " " + tabla.getIdInstancia()
							+ " ON ( "
							+ this.findCompareOfTablaJoin(reporteEstado, tabla.getIdTabla(), tabla.getIdInstancia())
							+ " )";
				}
			}
		}
		return query;
	}

	String findCompareOfTablaJoin(Reporte reporteEstado, int idTabla, String idInstancia) {
		String query = "";
		boolean flagFirst = true;
		for (TablaOnJoin join : reporteEstado.getTablasOnJoin()) {
			if (join.getIdTablaJoin() == idTabla && join.getInstanciaTablaJoin().equalsIgnoreCase(idInstancia)) {
				if (flagFirst) {
					// No posee operador logico
					flagFirst = false;
				} else {
					query += " " + join.getOperadorLogico();
				}
				query += " " + join.getInstanciaTablaBase() + "." + join.getCampoBase();
				query += " = " + join.getInstanciaTablaJoin() + "." + join.getCampoJoin();
			}
		}
		return query;
	}

	String getOnWhere(Reporte reporteEstado) {
		String query = "";
		query += " WHERE ";
		boolean flagExiste = false;
		for (CondicionQuery condicion : reporteEstado.getCondiciones()) {
			// Si se trata de una condicion del where
			if (condicion.getTipoCondicion() == 0) {
				if ((condicion.getIdCondicionPadre() == null||condicion.getIdCondicionPadre() == 0) && reporteEstado.getFiltros() != null) {
					flagExiste = true;
					List<Filtro> trucoLista = new ArrayList<Filtro>();
					List<Filtro> temporal = new ArrayList<Filtro>();
					for (Filtro filtro : reporteEstado.getFiltros()) {
						if (this.findCondicionById(reporteEstado, filtro.getIdCondicionPadre()).getTipoCondicion() == 0)
							temporal.add(filtro);
					}
					if (temporal.size() == 0)
						flagExiste = false;
					query += this.getInConditional(reporteEstado, 0, condicion, temporal, trucoLista, 0);
					break;
				}
			}
		}
		if (flagExiste)
			return query;
		else
			return "";
	}

	String getInConditional(Reporte reporteEstado, Integer index, CondicionQuery condicion, List<Filtro> temporal,
			List<Filtro> trucoLista, int tipoCondicion) {
		String query = "(";
		boolean flagFirst = true;
		for (Integer tempIndex = index; tempIndex < temporal.size(); tempIndex++) {
			Filtro filtro = temporal.get(tempIndex);
			if (filtro.getIdCondicionPadre() == condicion.getIdCondicionQuery()) {
				if (!trucoLista.contains(filtro)) {
					if (!flagFirst) {
						query += " " + condicion.getOperadorLogico() + " ";
					} else {
						flagFirst = false;
					}
					if (tipoCondicion == 0) {
						query += " " + filtro.getIdInstancia() + "." + filtro.getCampo() + " "
								+ filtro.getSimboloOperador() + " ";
						if (filtro.getTipoDatoValor().equalsIgnoreCase("VARCHAR2")
								|| filtro.getTipoDatoValor().equalsIgnoreCase("CHAR")) {
							query += "'" + filtro.getValor() + "'";
						} else {
							query += filtro.getValor();
						}
					} else {
						CampoQuery temporalCampo = this.findCampoById(reporteEstado, filtro.getIdCampo());
						query += " " + temporalCampo.getFuncionGrupo() + "( " + filtro.getIdInstancia() + "."
								+ filtro.getCampo() + " ) " + filtro.getSimboloOperador() + " ";
						if (filtro.getTipoDatoValor().equalsIgnoreCase("VARCHAR2")
								|| filtro.getTipoDatoValor().equalsIgnoreCase("CHAR")) {
							query += "'" + filtro.getValor() + "'";
						} else {
							query += filtro.getValor();
						}
					}
					trucoLista.add(filtro);
				}
			} else {
				if (this.getChildOrFatherCondition(reporteEstado,
						this.findCondicionById(reporteEstado, filtro.getIdCondicionPadre()), condicion) == 0) {
					if (!trucoLista.contains(filtro)) {
						if (!flagFirst) {
							query += " " + condicion.getOperadorLogico();
						} else {
							flagFirst = false;
						}
						query += " " + getInConditional(reporteEstado, tempIndex,
								this.getChildOrFather(reporteEstado,
										this.findCondicionById(reporteEstado, filtro.getIdCondicionPadre()), condicion),
								temporal, trucoLista, tipoCondicion);
					}
				} else
					break;
			}
		}
		query += ")";
		return query;
	}

	CampoQuery findCampoById(Reporte reporteEstado, int id_buscado) {
		for (CampoQuery campo : reporteEstado.getCampos()) {
			if (campo.getIdCampo() == id_buscado)
				return campo;
		}
		return null;
	}

	CondicionQuery findCondicionById(Reporte reporteEstado, int id_buscado) {
		for (CondicionQuery condicion : reporteEstado.getCondiciones()) {
			if (condicion.getIdCondicionQuery() == id_buscado) {
				return condicion;
			}
		}
		return null;
	}

	// metodo que retorna 0 si es padre y 1 si es hijo
	int getChildOrFatherCondition(Reporte reporteEstado, CondicionQuery condicion_origen,
			CondicionQuery condicion_destino) {
		CondicionQuery obtenerPadre = condicion_origen;
		boolean flagHijo = false;
		if (obtenerPadre.getIdCondicionPadre() != null) {
			while (obtenerPadre.getIdCondicionPadre() != condicion_destino.getIdCondicionQuery()) {
				obtenerPadre = this.findCondicionById(reporteEstado, obtenerPadre.getIdCondicionPadre());
				if (obtenerPadre.getIdCondicionPadre() == null) {
					flagHijo = true;
					break;
				}
			}
		} else
			flagHijo = true;
		if (flagHijo) {
			for (CondicionQuery condicion : reporteEstado.getCondiciones()) {
				if (condicion.getIdCondicionPadre() != null) {
					if (condicion.getIdCondicionPadre() == condicion_origen.getIdCondicionQuery()) {
						return 1;
					}
				}
			}
		}
		return 0;
	}

	CondicionQuery getChildOrFather(Reporte reporteEstado, CondicionQuery condicion_origen,
			CondicionQuery condicion_destino) {
		CondicionQuery obtenerPadre = condicion_origen;
		if (obtenerPadre.getIdCondicionPadre() != null) {
			while (obtenerPadre.getIdCondicionPadre() != condicion_destino.getIdCondicionQuery()) {
				obtenerPadre = this.findCondicionById(reporteEstado, obtenerPadre.getIdCondicionPadre());
				if (obtenerPadre.getIdCondicionPadre() == null) {
					break;
				}
			}
		}
		return obtenerPadre;
	}

	String getOnGroupBy(Reporte reporteEstado) {
		String query = "";
		if (this.findSomeOnGroupFunction(reporteEstado)) {
			boolean flagFirst = true;
			for (CampoQuery campo : reporteEstado.getCampos()) {
				if (campo.getFuncionGrupo() == null) {
					if (flagFirst) {
						query += " GROUP BY ";
						flagFirst = false;
					} else {
						query += ", ";
					}
					query += campo.getIdInstanciaTabla() + "." + campo.getCampo();
				}
			}
		}
		return query;
	}

	boolean findSomeOnGroupFunction(Reporte reporteEstado) {
		boolean flagFind = false;
		for (CampoQuery campo : reporteEstado.getCampos()) {
			if (campo.getFuncionGrupo() != null) {
				if (!(campo.getFuncionGrupo().isEmpty() || campo.getFuncionGrupo().isBlank()))
					flagFind = true;
			}
		}
		return flagFind;
	}

	String getOnHaving(Reporte reporteEstado) {
		String query = "";
		query += " HAVING ";
		boolean flagExiste = false;
		for (CondicionQuery condicion : reporteEstado.getCondiciones()) {
			// Si se trata de una condicion del where
			if (condicion.getTipoCondicion() == 1) {
				if (condicion.getIdCondicionPadre() == null && reporteEstado.getFiltros() != null) {
					flagExiste = true;
					List<Filtro> trucoLista = new ArrayList<Filtro>();
					List<Filtro> temporal = new ArrayList<Filtro>();
					for (Filtro filtro : reporteEstado.getFiltros()) {
						if (this.findCondicionById(reporteEstado, filtro.getIdCondicionPadre()).getTipoCondicion() == 1)
							temporal.add(filtro);
					}
					query += this.getInConditional(reporteEstado, 0, condicion, temporal, trucoLista, 1);
					break;
				}
			}
		}
		if (flagExiste)
			return query;
		else
			return "";
	}

	String getOnOrderBy(Reporte reporteEstado) {
		String query = "";
		boolean flagFirst = true;
		for (CampoQuery campo : reporteEstado.getCampos()) {
			if (campo.getEnOrderBy() != null) {
				if (flagFirst) {
					query += " ORDER BY ";
					flagFirst = false;
				} else {
					query += ", ";
				}
				if (campo.getFuncionGrupo() != null) {
					query += campo.getFuncionGrupo() + "(" + campo.getIdInstanciaTabla() + "." + campo.getCampo() + ")"
							+ " " + campo.getEnOrderBy();
				} else {
					query += campo.getIdInstanciaTabla() + "." + campo.getCampo() + " " + campo.getEnOrderBy();
				}
			}
		}
		return query;
	}

}
