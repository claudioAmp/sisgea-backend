package ob.unibanca.sicf.consultasgenerales.util.pagination.filter;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

//Le quite BUILDER
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "filterType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = NumberColumnFilter.class, name = "number"),
        @JsonSubTypes.Type(value = SetColumnFilter.class, name = "set") })
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ColumnFilter {
	 String filterType;
}
