package hu.papai.grana.validation;

import hu.papai.grana.model.DictionaryKey;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  Mark a String as a value for a Dictionary key.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DictionaryValidator.class)
public @interface Dictionary {

    String message() default "{hu.papai.grana.validation.Dictionary.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    DictionaryKey value();
}
