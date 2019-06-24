package ob.unibanca.sicf.consultasgenerales.util.pagination.filter;

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
public class NumberColumnFilter extends ColumnFilter{
	private String type;
    private Integer filter;
    private Integer filterTo;
}
