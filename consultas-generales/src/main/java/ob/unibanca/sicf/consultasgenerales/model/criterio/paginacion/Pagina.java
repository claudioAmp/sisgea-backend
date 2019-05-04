package ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

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
    public Pagina(S criterioBusqueda ,List<T> list) {
        if (list instanceof Page) {
            Page page = (Page) list;
            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();

            this.pages = page.getPages();
            this.listaDatos = page;
            this.total = page.getTotal();
           
            this.criterioBusqueda=criterioBusqueda;
            }
           else if (list instanceof Collection) {
                this.pageNum = 1;
                this.pageSize = list.size();

                this.pages = 1;
                this.listaDatos = list;
                this.total = list.size();
                
            }
            if (list instanceof Collection) {
               
            	limitadorPagina();
            }
      }
        private void limitadorPagina() {
            isFirstPage = pageNum == 1;
            isLastPage = pageNum == pages;
        }
  }
