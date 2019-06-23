package ob.unibanca.sicf.generadorconsultas.model.criterio.paginacion;

import com.github.pagehelper.Page;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaginaGeneradorConsulta<T> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static final boolean IS_TRUE = true;
	private static final boolean IS_FALSE = false;
	
	private int pageNum;
	private int pageSize;
	private long total;
	private int pages;
	private List<T> list;
	private boolean isFirstPage = false;
	private boolean isLastPage = false;
	private int firstRowIndex;
	private int lastRowIndex;
	
	
	public PaginaGeneradorConsulta(List<T> list) {
		this.setValues(list);
	}
	
	private void setValues(List<T> list){
		if (list instanceof Page) {
			Page<T> page = (Page<T>) list;
			this.pageNum = page.getPageNum();
			this.pageSize = page.getPageSize();
			this.pages = page.getPages();
			this.list = page;
			this.total = page.getTotal();
			this.firstRowIndex = this.pageNum > 0 ? (this.pageNum - 1) * this.pageSize : 0;
			this.isFirstPage = this.pageNum == 1 ? IS_TRUE : IS_FALSE;

			if(this.pageNum == this.pages) {
				this.isLastPage = true;
				this.lastRowIndex = (int) this.total;
			}
			else {
				this.isLastPage = false;
				this.lastRowIndex = this.firstRowIndex + this.pageSize * (this.pageNum > 0 ? 1 : 0);
			}
		}
	}

}
