package ob.unibanca.sicf.mantenimientosgenerales.controller.advice;

import ob.commons.validation.enumeration.BaseDatos;
import ob.commons.validation.model.ErrorResponse;
import ob.commons.validation.util.BaseDatosExcepcionUtil;
import ob.commons.validation.util.ErrorResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.sql.SQLException;

@RestControllerAdvice
public class AdviceMantenimientoGeneralRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdviceMantenimientoGeneralRestController.class);
	
	@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorResponse onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		logger.error(e.getMessage(), e); ErrorResponse errorResponse = ErrorResponseUtil.convertirErrorResponse(
				e.getBindingResult()); errorResponse.setCodigo(1); return errorResponse;
	}
	
	@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
	@ExceptionHandler(ConstraintViolationException.class)
	public ErrorResponse onConstraintViolationException(ConstraintViolationException e) {
		logger.error(e.getMessage(), e); ErrorResponse errorResponse = ErrorResponseUtil.convertirErrorResponse(e);
		errorResponse.setCodigo(1); return errorResponse;
	}
	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(SQLException.class)
	public ErrorResponse onSqlException(SQLException e) {
		logger.error(e.getMessage(), e);
		ErrorResponse errorResponse = BaseDatosExcepcionUtil.traducirExcepcionBaseDatos(e, BaseDatos.ORACLE);
		errorResponse.setCodigo(2); return errorResponse;
	}
}