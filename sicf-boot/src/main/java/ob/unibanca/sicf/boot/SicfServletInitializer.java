package ob.unibanca.sicf.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.io.File;

public class SicfServletInitializer extends SpringBootServletInitializer {
	
	private static final String UBA_SICF_CFG = "UBA_SICF_CFG";
	private static final String ARCHIVO_APP_PROPERTIES = "application.properties";
	private static Logger log = LoggerFactory.getLogger(SicfServletInitializer.class);
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		String rutaArchivoConfigSICF = System.getenv(UBA_SICF_CFG);
		if (rutaArchivoConfigSICF != null) {
			log.info("La variable de entorno {} tiene el valor de {}", UBA_SICF_CFG, rutaArchivoConfigSICF);
			if (!rutaArchivoConfigSICF.endsWith(File.separator)) {
				log.info("Añadiendo separador: {}", File.separator);
				rutaArchivoConfigSICF = rutaArchivoConfigSICF.concat(File.separator);
			}
			String rutaAppProperties = rutaArchivoConfigSICF.concat(ARCHIVO_APP_PROPERTIES);
			log.info("Verificando existencia del archivo de configuración {} definido en la variable de entorno {}",
					rutaAppProperties, UBA_SICF_CFG);
			if (new File(rutaAppProperties).exists()) {
				log.info("El archivo de configuración {} existe", rutaAppProperties);
				log.info("Configurando spring.config.location: {}", rutaArchivoConfigSICF);
				return application.sources(SicfBoot.class).properties(
						"spring.config.location:".concat(rutaArchivoConfigSICF));
			} else {
				log.info("El archivo de configuración {} no existe", rutaAppProperties);
				log.info("Cargando archivos de configuración del empaquetado WAR");
				return application.sources(SicfBoot.class).properties();
			}
		} else {
			log.info("La variabla de entorno {} no existe", UBA_SICF_CFG);
			log.info("Cargando archivos locales de configuración del empaquetado WAR");
			return application.sources(SicfBoot.class).properties();
		}
	}
}
