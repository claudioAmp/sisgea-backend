package ob.unibanca.sicf.consultasgenerales.util.pagination.request;


import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SortModel {
	private String colId;
    private String sort;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SortModel sortModel = (SortModel) o;
        return Objects.equals(colId, sortModel.colId) &&
                Objects.equals(sort, sortModel.sort);
    }

    @Override
    public int hashCode() {

        return Objects.hash(colId, sort);
    }

    @Override
    public String toString() {
        return "SortModel{" +
                "colId='" + colId + '\'' +
                ", sort='" + sort + '\'' +
                '}';
    }
}
