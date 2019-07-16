package ob.unibanca.sicf.generadorconsultas.service.generarconsulta;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.unibanca.sicf.generadorconsultas.model.CampoQuery;
import ob.unibanca.sicf.generadorconsultas.model.CondicionQuery;
import ob.unibanca.sicf.generadorconsultas.model.Filtro;
import ob.unibanca.sicf.generadorconsultas.model.Reporte;
import ob.unibanca.sicf.generadorconsultas.model.TablaOnJoin;
import ob.unibanca.sicf.generadorconsultas.model.TablaQuery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class GenerarConsultaService implements IGenerarConsultaService {

	@Override
	public String generarConsulta(Reporte reporteEstado) {
		//CambiosParaGenerateQuery
		Map<String, Integer> a = new HashMap<>();
	    String queryReporte;
	    queryReporte = "SELECT ";
	    queryReporte += this.getOnSelect(reporteEstado,a);
	    queryReporte += " FROM ";
	    queryReporte += this.getOnFrom(reporteEstado);
	    queryReporte += " ";
	    queryReporte += this.getOnWhere(reporteEstado);
		queryReporte += " ";
		queryReporte+=this.getOnGroupBy(reporteEstado);
		queryReporte += " ";
		queryReporte+=this.getOnHaving(reporteEstado);
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
	          query += " " + tabla.getTipoJoin()+ " JOIN " + tabla.getTabla() + " " + tabla.getIdInstancia() + " ON ( " + this.findCompareOfTablaJoin(reporteEstado,tabla.getIdTabla(), tabla.getIdInstancia()) + " )";
	        }
	      }
	    }
	    return query;
	  }

	  String findCompareOfTablaJoin(Reporte reporteEstado , int idTabla, String idInstancia){
	    String query = "";
	    boolean flagFirst=true;
	    for(TablaOnJoin join : reporteEstado.getTablasOnJoin()) {
	    	if(join.getIdTablaJoin()==idTabla && join.getInstanciaTablaJoin().equalsIgnoreCase(idInstancia)) {
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
	    query+=" WHERE ";
	    boolean flagExiste=false;
	    for(CondicionQuery condicion : reporteEstado.getCondiciones()) {
	    	//Si se trata de una condicion del where
	    	if(condicion.getTipoCondicion()==0) {
	    		if(condicion.getIdCondicionPadre()==null && reporteEstado.getFiltros()!=null) {
	    			flagExiste=true;
	    			List<Filtro> trucoLista=new ArrayList<Filtro>();
	    			  List<Filtro> temporal = new ArrayList<Filtro>();
	    			  for(Filtro filtro:reporteEstado.getFiltros()) {
	    				  if(this.findCondicionById(reporteEstado,filtro.getIdCondicionPadre()).getTipoCondicion()==0)
	    					  temporal.add(filtro);
	    			  }
	    			query+= this.getInConditional(reporteEstado,0,condicion,temporal,trucoLista);
	    			break;
	    		}
	    	}
	    }
	    if(flagExiste)
	    	return query;
	    else
	    	return "";
	  }
	  
	  String getInConditional(Reporte reporteEstado, Integer index,CondicionQuery condicion,List<Filtro> temporal ,List<Filtro> trucoLista) {
		  String query = "(";boolean flagFirst=true;
		  for(Integer tempIndex=index;tempIndex<temporal.size();tempIndex++) {
			  Filtro filtro=temporal.get(tempIndex);
			  if(filtro.getIdCondicionPadre()==condicion.getIdCondicionQuery()) {
				  if(!trucoLista.contains(filtro)) {
					  if(!flagFirst) {
						  query+=" "+condicion.getOperadorLogico()+" ";
					  } else {
						  flagFirst=false;
					  }
					  query+=" "+filtro.getIdInstancia()+"."+filtro.getCampo()+" "+filtro.getSimboloOperador()+" "+filtro.getValor();
					  trucoLista.add(filtro);
				  }
			  } else {
				  if(this.getChildOrFatherCondition(reporteEstado,this.findCondicionById(reporteEstado,filtro.getIdCondicionPadre()), condicion)==0) {
					  if(!trucoLista.contains(filtro)) {
						  if(!flagFirst) {
							  query+=" "+condicion.getOperadorLogico();
						  } else {
							  flagFirst=false;
						  }
						  query+=" "+getInConditional(reporteEstado,tempIndex,this.getChildOrFather(reporteEstado,this.findCondicionById(reporteEstado,filtro.getIdCondicionPadre()), condicion),temporal,trucoLista);
					  }
				  } else 
					  break;
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
	  
	  //metodo que retorna 0 si es padre y 1 si es hijo
	  int getChildOrFatherCondition(Reporte reporteEstado,CondicionQuery condicion_origen,CondicionQuery condicion_destino) {
		  CondicionQuery obtenerPadre=condicion_origen;boolean flagHijo=false;
		  if(obtenerPadre.getIdCondicionPadre()!=null) {
			  while(obtenerPadre.getIdCondicionPadre()!=condicion_destino.getIdCondicionQuery()) {
				  obtenerPadre=this.findCondicionById(reporteEstado, obtenerPadre.getIdCondicionPadre());
				  if(obtenerPadre.getIdCondicionPadre()==null) {
					  flagHijo=true;
					  break;
				  }
			  }
		  } else 
			  flagHijo=true;
		  if(flagHijo) {
			  for(CondicionQuery condicion:reporteEstado.getCondiciones()) {
				  if(condicion.getIdCondicionPadre()!=null) {
					  if(condicion.getIdCondicionPadre()==condicion_origen.getIdCondicionQuery()) {
						  return 1;
					  }
				  }
			  }
		  }
		  return 0;
	  }
	  
	  CondicionQuery getChildOrFather(Reporte reporteEstado,CondicionQuery condicion_origen,CondicionQuery condicion_destino) {
		  CondicionQuery obtenerPadre=condicion_origen;boolean flagHijo=false;
		  if(obtenerPadre.getIdCondicionPadre()!=null) {
			  while(obtenerPadre.getIdCondicionPadre()!=condicion_destino.getIdCondicionQuery()) {
				  obtenerPadre=this.findCondicionById(reporteEstado, obtenerPadre.getIdCondicionPadre());
				  if(obtenerPadre.getIdCondicionPadre()==null) {
					  flagHijo=true;
					  break;
				  }
			  }
		  }
		  return obtenerPadre;
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
	  
	  String getOnHaving(Reporte reporteEstado) {
		  String query = "";
		    query+=" HAVING ";
		    boolean flagExiste=false;
		    for(CondicionQuery condicion : reporteEstado.getCondiciones()) {
		    	//Si se trata de una condicion del where
		    	if(condicion.getTipoCondicion()==1) {
		    		if(condicion.getIdCondicionPadre()==null && reporteEstado.getFiltros()!=null) {
		    			flagExiste=true;
		    			List<Filtro> trucoLista=new ArrayList<Filtro>();
		    			  List<Filtro> temporal = new ArrayList<Filtro>();
		    			  for(Filtro filtro:reporteEstado.getFiltros()) {
		    				  if(this.findCondicionById(reporteEstado,filtro.getIdCondicionPadre()).getTipoCondicion()==1)
		    					  temporal.add(filtro);
		    			  }
		    			query+= this.getInConditional(reporteEstado,0,condicion,temporal,trucoLista);
		    			break;
		    		}
		    	}
		    }
		    if(flagExiste)
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
	        query += campo.getIdInstanciaTabla() + "." +campo.getCampo()+" "+ campo.getEnOrderBy();
	      }
	    }
	    return query;
	}

}
