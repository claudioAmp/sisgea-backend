package ob.unibanca.sicf.mantenimientosgenerales.controller.advicecontroller;

import ob.commons.validation.enumeration.BaseDatos;
import ob.commons.validation.model.ErrorFormularioResponse;
import ob.commons.validation.model.ErrorResponse;
import ob.commons.validation.util.BaseDatosExcepcionUtil;
import ob.commons.validation.util.ValidacionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class AdviceRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdviceRestController.class);
	
	@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorResponse onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		BindingResult bindingResult = e.getBindingResult();
		List<ErrorFormularioResponse> errorFormularioResponses = bindingResult.getFieldErrors().stream().map(
				fieldError -> new ErrorFormularioResponse(fieldError.getCode(), fieldError.getField(),
				                                          fieldError.getDefaultMessage(),
				                                          fieldError.getRejectedValue())).collect(Collectors.toList());
		logger.error("No se pudo completar la petición dado que la entidad tiene valores inválidos: {}",
		             errorFormularioResponses); logger.error(e.getMessage(), e); return new ErrorResponse(1,
		                                                                                                  "Entidad no " +
		                                                                                                  "procesable",
		                                                                                                  errorFormularioResponses);
	}
	
	@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
	@ExceptionHandler(ConstraintViolationException.class)
	public ErrorResponse onConstraintViolationException(ConstraintViolationException e) {
		List<ErrorFormularioResponse> errorFormularioResponses = e.getConstraintViolations().stream().map(
				fieldError -> new ErrorFormularioResponse(ValidacionUtil.extraerNombreAnotacion(
						fieldError.getConstraintDescriptor().getAnnotation().toString()), ValidacionUtil
						                                          .extraerAtributo(
								                                          fieldError.getPropertyPath().toString()),
				                                          fieldError.getMessage(), fieldError.getInvalidValue()))
		                                                          .collect(Collectors.toList()); logger.error(
				e.getMessage(), e); return new ErrorResponse(1, "Parámetro o entidad no procesable",
		                                                     errorFormularioResponses);
	}
	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(SQLException.class)
	public ErrorResponse onSqlException(SQLException e) {
		logger.error(e.getMessage(), e);
		ErrorResponse errorResponse = BaseDatosExcepcionUtil.traducirExcepcionBaseDatos(e, BaseDatos.ORACLE);
		errorResponse.setCodigo(2); return errorResponse;
	}
}