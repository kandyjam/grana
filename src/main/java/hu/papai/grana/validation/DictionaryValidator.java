package hu.papai.grana.validation;

import hu.papai.grana.model.DictionaryKey;
import hu.papai.grana.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Collection;

public class DictionaryValidator implements ConstraintValidator<Dictionary, String> {

    /**
     * Values corresponding to the given key will be checked against the provided field.
     */
    private DictionaryKey dictKey;

    @Autowired
    private DictionaryService service;

    @Override
    public void initialize(Dictionary constraintAnnotation) {
        dictKey = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        Collection<String> allowedValues = service.getValuesForKey(dictKey);
        return allowedValues.stream().anyMatch(value::equals);
    }
}
