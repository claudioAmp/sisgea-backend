package edu.taller.sisgea.consultasgenerales.model.establecimientodcp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.spring.validation.validation.IdCadena;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstablecimientoDcp {

    @IdCadena(maxLength = 10)
    private String idEstablecimiento;
    private String direccion;
    private String ciudad;
    private String codigoPostal;
    private String grupo;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    Date fechaProceso;

}
