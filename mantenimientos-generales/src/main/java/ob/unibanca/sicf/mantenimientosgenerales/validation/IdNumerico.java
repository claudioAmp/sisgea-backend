package ob.unibanca.sicf.mantenimientosgenerales.validation;

import org.hibernate.validator.constraints.Range;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Range
@NotNull
@Constraint(validatedBy = {})
@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface IdNumerico {
	
	String message() default "El identificador númerico tiene un formato incorrecto";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	
	@OverridesAttribute(constraint = Range.class, name = "min") long minRange() default 1;
	
	@OverridesAttribute(constraint = Range.class, name = "max") long maxRange();
	
	@OverridesAttribute(constraint = Range.class,
	                    name = "message") String messageRange() default "El identificador debe estar entre {min} y " +
	                                                                    "{max}";
	
	@OverridesAttribute(constraint = NotNull.class,
	                    name = "message") String messageNotNull() default "El identificador no debe ser nulo";
}
