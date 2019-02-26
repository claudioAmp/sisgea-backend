package ob.unibanca.sicf.mantenimientosgenerales.validation;

import org.hibernate.validator.constraints.Length;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Length
@NotNull
@NotBlank
@Constraint(validatedBy = {})
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Descripcion {
	
	String message() default "La descripción tiene un formato incorrecto";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	
	@OverridesAttribute(constraint = Length.class, name = "min") int minLength();
	
	@OverridesAttribute(constraint = Length.class, name = "max") int maxLength();
	
	@OverridesAttribute(constraint = Length.class,
	                    name = "message") String messageLength() default "La descripcion debe contener entre {min} y " +
	                                                                     "{max} caracteres";
	
	@OverridesAttribute(constraint = NotNull.class,
	                    name = "message") String messageNotNull() default "La descripción no debe ser nulo";
	
	@OverridesAttribute(constraint = NotBlank.class,
	                    name = "message") String messageNotBlank() default "La descripción no debe contener solo espacios en blanco";
}
