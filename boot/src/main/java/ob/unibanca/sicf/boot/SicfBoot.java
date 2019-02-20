package ob.unibanca.sicf.boot;

import ob.unibanca.sicf.facturacion.FacturacionBoot;
import ob.unibanca.sicf.mantenimientosgenerales.MantenimientosGeneralesBoot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Esta clase se encarga de arrancar los módulos declarados en el pom.xml
 * <p>
 * Para realizar el arranque de los módulos, es necesario que en la anotación
 * {@code @SpringBootApplication} se declaren las clases Main de dichos módulos
 * </p>
 */
@SpringBootApplication(scanBasePackageClasses = {MantenimientosGeneralesBoot.class, FacturacionBoot.class})
public class SicfBoot {

    public static void main(String[] args) {
        SpringApplication.run(SicfBoot.class, args);
    }
}
