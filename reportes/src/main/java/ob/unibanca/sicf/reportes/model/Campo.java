package ob.unibanca.sicf.reportes.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Campo {
	private int idTabla;
    private String tabla;
	private int idCampo;
	private String campo;
}
