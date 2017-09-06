package hu.papai.grana.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DiscTestValidator.class)
public @interface DiscTest {

    String message() default "{hu.papai.grana.validation.StandardDiscTestResult.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
