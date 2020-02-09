package edu.taller.sisgea.consultasgenerales.model.criterio.paginacion;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pagina<S,T>   implements Serializable {
	private static final long serialVersionUID = 1L;

    private int pageNum;

    private int pageSize;

    private long total;

    private int pages;
    
    private S criterioBusqueda;
    
    private List<T> listaDatos;

    private boolean isFirstPage = false;

    private boolean isLastPage = false;
   
    private int indexFirstOfRows;
   
    private int indexLastOfRows;

    
    public Pagina(S criterioBusqueda ,List<T> list) {
        if (list instanceof Page) {
            Page page = (Page) list;
            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();
            this.pages = page.getPages();
            this.listaDatos = page;
            this.total = page.getTotal();
            this.criterioBusqueda=criterioBusqueda;
            this.indexFirstOfRows = this.pageNum > 0 ? (this.pageNum - 1) * this.pageSize : 0;
            if(this.pageNum == 1) {
            	this.isFirstPage = true;
            }else {
            	this.isFirstPage = false;
            }
            if(this.pageNum == this.pages) {
            	this.isLastPage = true;
            	this.indexLastOfRows = (int) this.total;
            }else {
            	this.isLastPage = false;
            	this.indexLastOfRows = this.indexFirstOfRows + this.pageSize * (this.pageNum > 0 ? 1 : 0);
            }
         
                      
          }
      }
       

  }
