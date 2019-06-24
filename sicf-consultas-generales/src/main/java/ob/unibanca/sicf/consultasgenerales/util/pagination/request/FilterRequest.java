package ob.unibanca.sicf.consultasgenerales.util.pagination.request;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.unibanca.sicf.consultasgenerales.util.pagination.filter.ColumnFilter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilterRequest {
	 private Map<String, ColumnFilter> filterModel;
	 @Override
	    public String toString() {
	        return "FilterRequest{" +
	                "filterModel=" + filterModel +
	                '}';
	    }
}
