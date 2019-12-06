package ob.unibanca.sicf.consultasgenerales.model.irregular;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
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
public class IrregularComis {
	private Long idSecuencia;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProceso;
	private Integer indRegularizada;
	private Integer idComision;
	private Integer idCuentaCompensacion;
	private String registroContable;
	private Integer idTipoCtaComp;


}
