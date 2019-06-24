package ob.unibanca.sicf.consultasgenerales.util.pagination.response;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnterpriseGetRowsResponse {
	private List<Map<String, Object>> data;
    //private int lastRow;
    private List<String> secondaryColumnFields;
}
