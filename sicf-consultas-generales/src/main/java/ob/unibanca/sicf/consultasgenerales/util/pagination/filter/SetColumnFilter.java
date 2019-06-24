package ob.unibanca.sicf.consultasgenerales.util.pagination.filter;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SetColumnFilter extends ColumnFilter {
	private List<String> values;
}
