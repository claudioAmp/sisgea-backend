package ob.unibanca.sicf.consultasgenerales.util.pagination.request;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ColumnVO implements Serializable{
	private String id;
    private String displayName;
    private String field;
    private String aggFunc;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColumnVO columnVO = (ColumnVO) o;
        return Objects.equals(id, columnVO.id) &&
                Objects.equals(displayName, columnVO.displayName) &&
                Objects.equals(field, columnVO.field) &&
                Objects.equals(aggFunc, columnVO.aggFunc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, displayName, field, aggFunc);
    }
}
