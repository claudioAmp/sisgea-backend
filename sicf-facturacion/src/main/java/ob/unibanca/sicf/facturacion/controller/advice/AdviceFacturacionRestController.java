package ob.unibanca.sicf.facturacion.controller.advice;

import ob.commons.error.enumeration.BaseDatos;
import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.error.model.ErrorResponse;
import ob.commons.error.util.BaseDatosExcepcionUtil;
import ob.commons.error.util.ErrorResponseUtil;
import ob.commons.excel.exception.ReadingExcelFileException;
import ob.commons.excel.util.ReadingExcelFileExceptionUtil;
import ob.commons.spring.validation.util.ValidationErrorResponseUtil;
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
public class AdviceFacturacionRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdviceFacturacionRestController.class);
	
	@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorResponse onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		logger.error(e.getMessage(), e);
		return ValidationErrorResponseUtil.convertirErrorResponse(e.getBindingResult());
	}
	
	@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
	@ExceptionHandler(ConstraintViolationException.class)
	public ErrorResponse onConstraintViolationException(ConstraintViolationException e) {
		logger.error(e.getMessage(), e);
		return ValidationErrorResponseUtil.convertirErrorResponse(e);
	}
	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(SQLException.class)
	public ErrorResponse onSqlException(SQLException e) {
		logger.error(e.getMessage(), e);
		return BaseDatosExcepcionUtil.traducirExcepcionBaseDatos(e, BaseDatos.ORACLE);
	}
	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ReadingExcelFileException.class)
	public ErrorResponse onReadingExcelFileException(ReadingExcelFileException e) {
		logger.error(e.getMessage(), e);
		return ReadingExcelFileExceptionUtil.traducirException(e);
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(RecursoNoEncontradoException.class)
	public ErrorResponse onRecursoNoEncontradoException(RecursoNoEncontradoException e) {
		logger.error(e.getMessage(), e);
		return ErrorResponseUtil.convertirErrorResponse(e);
	}
}