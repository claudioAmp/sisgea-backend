package ob.unibanca.sicf.generadorconsultas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Operador{
   @IdNumerico(maxRange = 999, groups = IRegistro.class)
   Integer idOperador;
   String simboloOperador;
   String descripcionOperador;
   String operador; // por la vista
   String idTipoOperador;
   String tipoOperador; //por la vista
}