package ob.unibanca.sicf.mantenimientosgenerales.controller.advicecontroller;

import ob.unibanca.sicf.mantenimientosgenerales.model.error.ErrorFormularioResponse;
import ob.unibanca.sicf.mantenimientosgenerales.model.error.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class AdviceRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdviceRestController.class);
	
	@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorResponse handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		BindingResult bindingResult = e.getBindingResult();
		List<ErrorFormularioResponse> errorFormularioResponses = bindingResult.getFieldErrors().stream().map(
				fieldError -> ErrorFormularioResponse.builder().codigoErrorCampo(fieldError.getCode()).nombreCampo(
						fieldError.getField()).mensajeErrorCampo(fieldError.getDefaultMessage())
				                                     .valorRechazadoCampo(fieldError.getRejectedValue()).build())
		                                                                      .collect(Collectors.toList());
		logger.error("No se pudo completar la petición dado que la entidad tiene valores inválidos: {}",
		             errorFormularioResponses); logger.error(e.getMessage(), e); return ErrorResponse.builder().codigo(
				1).mensajeUsuario("Entidad no procesable").errorFormularioResponses(errorFormularioResponses).build();
	}
}
