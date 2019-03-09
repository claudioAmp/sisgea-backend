package ob.unibanca.sicf.boot;

import ob.unibanca.sicf.facturacion.FacturacionBoot;
import ob.unibanca.sicf.mantenimientosgenerales.MantenimientosGeneralesBoot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.util.Arrays;
import java.util.Collections;

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
	
	/**
	 * En este método se configuran la integración con distintos origenes de petición.
	 * <p>
	 * <b>Nota:</b> Esta método será reubicada
	 * </p>
	 *
	 * @return CorsFilert con los origenes configurados
	 */
	@Bean
	public CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.setAllowedOrigins(Collections.singletonList("*"));
		config.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept"));
		config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH"));
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(3 * 1024 * 1024);	// 3MB
		return multipartResolver;
	}
}
