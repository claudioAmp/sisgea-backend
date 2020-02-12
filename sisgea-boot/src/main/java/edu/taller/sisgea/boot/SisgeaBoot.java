package edu.taller.sisgea.boot;

import edu.taller.sisgea.consultasgenerales.ConsultasGeneralesBoot;
import edu.taller.sisgea.mantenimientosgenerales.MantenimientosGeneralesBoot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(
		scanBasePackageClasses = {MantenimientosGeneralesBoot.class,
		                          ConsultasGeneralesBoot.class})
public class SisgeaBoot {
	
	public static void main(String[] args) {
		SpringApplication.run(SisgeaBoot.class, args);
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
