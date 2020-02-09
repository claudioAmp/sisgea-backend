package edu.taller.sisgea.boot;

import ob.commons.jwt.JWTUtil;
import edu.taller.sisgea.consultasgenerales.ConsultasGeneralesBoot;
import edu.taller.sisgea.mantenimientosgenerales.MantenimientosGeneralesBoot;
import edu.taller.sisgea.visualizacionpan.VisualizacionPANBoot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Esta clase se encarga de arrancar los módulos declarados en el pom.xml.
 * <p>
 * Para realizar el arranque de los módulos, es necesario que en la anotación
 * {@code @SpringBootApplication} se declaren las clases Main de dichos módulos.
 * </p>
 *
 * @author Hanz Llanto
 */
@SpringBootApplication(
		scanBasePackageClasses = {MantenimientosGeneralesBoot.class,
		                          ConsultasGeneralesBoot.class,
		                          VisualizacionPANBoot.class})
public class SisgeaBoot {
	
	public static void main(String[] args) {
		SpringApplication.run(SisgeaBoot.class, args);
	}
	
	/**
	 * En este método se configuran la integración con distintos origenes de petición.
	 * Las configuraciones se aplican si la propiedad ob.sicf.cors.activo es true.
	 * <p>
	 * <b>Nota:</b> Esta método será reubicada
	 * </p>
	 *
	 * @return CorsFilter con los origenes configurados
	 */
	@ConditionalOnProperty(value = "ob.sicf.cors.activo", havingValue = "true")
	@Bean
	public CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.setAllowedOrigins(Collections.singletonList("*"));
		config.setAllowedHeaders(
				Arrays.asList("Access-Control-Allow-Origin", "Content-Type", "Accept", JWTUtil.JWT_ENCABEZADO));
		config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH"));
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}
	
	/**
	 * Permite establecer la lista de {@link ViewResolver} que serán utilizados.
	 *
	 * @param manager negociador que determina el {@code media type} solicitado en
	 *                una petición
	 * @return {@link ContentNegotiatingViewResolver}
	 */
	@Bean
	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setContentNegotiationManager(manager);
		List<ViewResolver> resolvers = new ArrayList<>();
		resolvers.add(resourceBundleViewResolver());
		resolver.setViewResolvers(resolvers);
		return resolver;
	}
	
	/**
	 * Define un {@link ResourceBundleViewResolver} que permite el procesamiento
	 * de los templates definidos en el archivo <b>views/views.properties</b>.
	 *
	 * @return {@link ResourceBundleViewResolver}
	 */
	@Bean
	public ResourceBundleViewResolver resourceBundleViewResolver() {
		ResourceBundleViewResolver resolver = new ResourceBundleViewResolver();
		resolver.setOrder(0);
		resolver.setBasename("views/views");
		return resolver;
	}
	
	/**
	 * Configuracion para carga de archivos
	 *
	 * @return {@link CommonsMultipartResolver }
	 */
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(3L * 1024L * 1024L);    // 3MB
		return multipartResolver;
	}
}
