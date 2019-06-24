package ob.unibanca.sicf.consultasgenerales.util.pagination;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstructuraConsulta {
	String selectSql;
	String whereSql;
	String groupBySql;
	String orderBySql;
}
