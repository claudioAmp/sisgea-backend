package ob.unibanca.sicf.consultasgenerales.util.pagination.request;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ob.unibanca.sicf.consultasgenerales.util.pagination.filter.ColumnFilter;


@Data
@Builder
@AllArgsConstructor
public class EnterpriseGetRowsRequest {
	int startRow;
	int endRow;
    // true if pivot mode is one, otherwise false
    private boolean pivotMode;

    // what groups the user is viewing
    private List<String> groupKeys;

    // if filtering, what the filter model is
    private Map<String, ColumnFilter> filterModel;

    // if sorting, what the sort model is
    private List<SortModel> sortModel;
    
    public EnterpriseGetRowsRequest() {
        
        this.groupKeys = emptyList();
        this.filterModel = emptyMap();
        this.sortModel = emptyList();
    }
}
