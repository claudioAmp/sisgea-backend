package ob.unibanca.sicf.generadorconsultas.service.generarconsulta;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.generadorconsultas.model.CampoQuery;
import ob.unibanca.sicf.generadorconsultas.model.Filtro;
import ob.unibanca.sicf.generadorconsultas.model.Reporte;
import ob.unibanca.sicf.generadorconsultas.model.TablaQuery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;

public class GenerarConsultaService implements IGenerarConsultaService {

	List<CampoQuery> allCampos;

	public GenerarConsultaService(@Qualifier("ICampoQueryMapper") IMantenibleMapper<CampoQuery> mantenibleMapper) {
		this.allCampos = (List<CampoQuery>) mantenibleMapper.buscarTodos();
	}

	@Override
	public String generarConsulta(Reporte reporteEstado) {
		//CambiosParaGenerateQuery
		Map<String, Integer> a = new HashMap<>();
	    String queryReporte;
	    queryReporte = "SELECT";
	    queryReporte += this.getOnSelect(reporteEstado,a);
	    queryReporte += " FROM";
	    queryReporte += this.getOnFrom(reporteEstado);
	    queryReporte += " ";
	    queryReporte += this.getOnWhere(reporteEstado);
	    queryReporte += " ";
	    queryReporte += this.getOnOrderBy(reporteEstado);
	    return queryReporte;
	}
	
	String getOnSelect(Reporte reporteEstado , Map<String, Integer> a ) {
	    String query = "";
	    boolean flagFirst = true;
	    for (CampoQuery campo :reporteEstado.getCampos()) {
	      if (campo.isEnSelect()) {
	        //Logica para colocar en el query
	        if (flagFirst) {
	          query += " ";
	          flagFirst = false;
	        } else {
	          query += ", ";
	        }
	        query += campo.getIdInstanciaTabla() + "." + this.findFieldName(campo.getIdCampo()) + " AS " + "\"" ;
	        String b=campo.getCampo();
	        if(a.get(b)==null){
	          a.put(b, 0);
	          query+= campo.getCampo() +"\"";
	        }else{
			  a.put(b, a.get(b)+1);
	          query+= campo.getCampo() + a.get(b)+"\"";
	        }
	      }
	    }
	    return query;
	  }

	  String findFieldName(int id){
	    for (CampoQuery campo : this.allCampos) {
	      if (campo.getIdCampo() == id)
	        return campo.getCampo();
		}
		return null;
	  }

	  String getOnFrom(Reporte reporteEstado ) {
	    String query = "";
	    boolean flagFrom = true;
	    if (reporteEstado.getTablas().size() == 1) {
	      TablaQuery tabla = reporteEstado.getTablas().get(0);
	      query +=  tabla.getTabla() + tabla.getIdInstancia();
	    }
	    else {
	      for (TablaQuery tabla : reporteEstado.getTablas()) {
	        if (flagFrom) {
	          query += tabla.getTabla() + tabla.getIdInstancia();
	          flagFrom = false;
	        } else {
	          query += " INNER JOIN " + tabla.getTabla() + " " + tabla.getIdInstancia() + " ON ( " + this.findCompareOfTablaJoin(reporteEstado,tabla.getIdTabla(), tabla.getIdInstancia()) + " )";
	        }
	      }
	    }
	    return query;
	  }

	  String findCompareOfTablaJoin(Reporte reporteEstado , int idTabla, String idInstancia){
	    String query = "";
	    for (CampoQuery campo : reporteEstado.getCampos()) {
	      if (campo.getIdTabla() == idTabla && campo.getIdInstanciaTabla() == idInstancia) {
	        if (campo.getIdTablaFrom() != 0 && campo.getIdInstanciaTablaFrom() != "" && campo.getIdCampoFrom() != 0) {
	          query += " " + campo.getIdInstanciaTablaFrom() + "." + this.findFieldNameAlias(reporteEstado,campo.getIdTablaFrom(), campo.getIdInstanciaTablaFrom(), campo.getIdCampoFrom());
	          query += " = " + campo.getIdInstanciaTabla() + "." + this.findFieldNameAlias(reporteEstado,campo.getIdTabla(), campo.getIdInstanciaTabla(), campo.getIdCampo());
	          return query;
	        }
	      }
		}
		return query;
	  }

	  //funcion que recibe la tabla, instancia y un identificador del campo y devuelve su alias en caso lo tenga y sino su nombre
	  String findFieldNameAlias(Reporte reporteEstado , int tabla, String instancia,int idCampo) {
	    for (CampoQuery campo : reporteEstado.getCampos()) {
	      if (campo.getIdTabla() == tabla && campo.getIdInstanciaTabla() == instancia && campo.getIdCampo() == idCampo) {
	        if (campo.getCampo() != null && campo.getCampo() != "") {
	          return campo.getCampo();
	        } else {
	          return this.findFieldName(campo.getIdCampo());
	        }
	      }
		}
		return null;
	  }

	  String getOnWhere(Reporte reporteEstado ) {
	    String query = "";
	    if(reporteEstado.getFiltros()==null) {
	      return query;}
	    boolean flagFirst = true;
	    query+=" (";
	    for (Filtro filtro : reporteEstado.getFiltros()) {
	      if (filtro.getTipoFiltro() == 0) {
	        if (flagFirst) {
	          query += "WHERE ("; flagFirst = false;
	        } else {
	          filtro.setOperadorLogico(filtro.getOperadorLogico().equals("O") ? "OR" : "AND");
	          query += " " + filtro.getOperadorLogico();
	        }
	        query += " " + filtro.getIdInstancia() + "." + this.findFieldNameAlias(reporteEstado,filtro.getIdTabla(), filtro.getIdInstancia(), filtro.getIdCampo());
	        String operador = filtro.getSimboloOperador();
	        if (operador == "=" || operador == "<" || operador == ">" || operador == "<=" || operador == ">=" || operador == "LIKE" || operador == "!=") {
	          switch (filtro.getTipoDatoValor()) {
	            case "VARCHAR2":
	            case "DATE":
				{
				  query += " " + operador + " '" + filtro.getValor() + "' ";
				  break;
				}
	            default: {
	              query += " " + operador + " " + filtro.getValor();
	            }

	          }

	        } 
	          query += " )";
	        }
	      }
	    if (!flagFirst)
	      query += " )";
	    return query;
	  }

	  String getOnOrderBy(Reporte reporteEstado) {
	    String query = "";
	    boolean flagFirst = true;
	    for (CampoQuery campo : reporteEstado.getCampos()) {
	      if (campo.getOrderBy() != null) {
	        if (flagFirst) {
	          query += " ORDER BY ";
	          flagFirst = false;
	        } else {
	          query += ", ";
	        }
	        query += campo.getIdInstanciaTabla() + "." + this.findFieldNameAlias(reporteEstado,campo.getIdTabla(), campo.getIdInstanciaTabla(), campo.getIdCampo()) + " " + campo.getOrderBy();
	      }
	    }
	    return query;
	}

}
