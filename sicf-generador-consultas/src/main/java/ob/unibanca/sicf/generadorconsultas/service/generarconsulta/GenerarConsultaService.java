package ob.unibanca.sicf.generadorconsultas.service.generarconsulta;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.generadorconsultas.model.CampoQuery;
import ob.unibanca.sicf.generadorconsultas.model.CondicionQuery;
import ob.unibanca.sicf.generadorconsultas.model.Filtro;
import ob.unibanca.sicf.generadorconsultas.model.Reporte;
import ob.unibanca.sicf.generadorconsultas.model.TablaOnJoin;
import ob.unibanca.sicf.generadorconsultas.model.TablaQuery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;

public class GenerarConsultaService implements IGenerarConsultaService {

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
		queryReporte+=this.getOnGroupBy(reporteEstado);
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
			if(campo.getFuncionGrupo()!=null){
				query+=campo.getFuncionGrupo()+"("+campo.getIdInstanciaTabla() + "." + campo.getCampo()+")";
			} else {
				query += campo.getIdInstanciaTabla() + "." + campo.getCampo() ;
			}
			query += " AS " + "\"" ;
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

	  String getOnFrom(Reporte reporteEstado ) {
	    String query = "";
	    boolean flagFrom = true;
	    if (reporteEstado.getTablas().size() == 1) {
	      TablaQuery tabla = reporteEstado.getTablas().get(0);
	      query +=  tabla.getTabla() + " " + tabla.getIdInstancia();
	    }
	    else {
	      for (TablaQuery tabla : reporteEstado.getTablas()) {
	        if (flagFrom) {
	          query += tabla.getTabla() + " " + tabla.getIdInstancia();
	          flagFrom = false;
	        } else {
	          query += " " + tabla.getTipoJoin()+ " " + tabla.getTabla() + " " + tabla.getIdInstancia() + " ON ( " + this.findCompareOfTablaJoin(reporteEstado,tabla.getIdTabla(), tabla.getIdInstancia()) + " )";
	        }
	      }
	    }
	    return query;
	  }

	  String findCompareOfTablaJoin(Reporte reporteEstado , int idTabla, String idInstancia){
	    String query = "";
	    boolean flagFirst=true;
	    for(TablaOnJoin join : reporteEstado.getTablasOnJoin()) {
	    	if(join.getIdTablaBase()==idTabla && join.getInstanciaTablaBase()==idInstancia) {
	    		if(flagFirst) {
	    			//No posee operador logico
	    			flagFirst=false;
	    		} else {
	    			query+=" "+join.getOperadorLogico();
	    		}
	    		query += " " + join.getInstanciaTablaBase() + "." + join.getCampoBase();
    			query += " = " + join.getInstanciaTablaJoin() + "." + join.getCampoJoin();
    		}
	    }
		return query;
	  }

	  String getOnWhere(Reporte reporteEstado ) {
	    String query = "";
	    if(reporteEstado.getFiltros()==null) {
	      return query;}
	    boolean flagFirst = true;
	    query+="WHERE (";
	    for(CondicionQuery condicion : reporteEstado.getCondiciones()) {
	    	//Si se trata de una condicion del where
	    	if(condicion.getTipoCondicion()==0) {
	    		if(condicion.getIdCondicionPadre()==null) {
	    			query+= this.getInWhere(reporteEstado,0,condicion);
	    		}
	    	}
	    }
	    query += " )";
	    return query;
	  }
	  
	  String getInWhere(Reporte reporteEstado, int index,CondicionQuery condicion) {
		  String query = "(";boolean flagFirst=true;
		  for(int tempIndex=index;tempIndex<reporteEstado.getFiltros().size();tempIndex++) {
			  Filtro filtro=reporteEstado.getFiltros().get(tempIndex);
			  if(filtro.getIdCondicionPadre()==condicion.getIdCondicionQuery()) {
				  if(!flagFirst) {
					  query+=" "+condicion.getOperadorLogico()+" ";
				  } else {
					  flagFirst=false;
				  }
				  query+=filtro.getIdInstancia()+"."+filtro.getCampo()+filtro.getSimboloOperador()+filtro.getValor();
			  } else {
				  if(!flagFirst) {
					  query+=" "+condicion.getOperadorLogico()+" "+getInWhere(reporteEstado,tempIndex,this.findCondicionById(reporteEstado,filtro.getIdCondicionPadre()));
				  } else {
					  query+=getInWhere(reporteEstado,tempIndex,this.findCondicionById(reporteEstado,filtro.getIdCondicionPadre()));
				  }
			  }
		  }
		  query+=")";
		  return query;
	  }
	  
	  CondicionQuery findCondicionById(Reporte reporteEstado,int id_buscado) {
		  for(CondicionQuery condicion:reporteEstado.getCondiciones()) {
			  if(condicion.getIdCondicionQuery()==id_buscado) {
				  return condicion;
			  }
		  }
		  return null;
	  }

	  String getOnGroupBy(Reporte reporteEstado) {
		String query = "";
		boolean flagFirst = true;
		for(CampoQuery campo:reporteEstado.getCampos()){
			if(campo.getFuncionGrupo()==null){
				if(flagFirst){
					query+=" GROUP BY ";
					flagFirst=false;
				}else{
					query += ", ";
				}
				query += campo.getIdInstanciaTabla() + "." + campo.getCampo();
			}
		}
		return query;
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
	        query += campo.getIdInstanciaTabla() + "." + campo.getEnOrderBy();
	      }
	    }
	    return query;
	}

}
