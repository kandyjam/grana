package hu.papai.grana.validation;

import hu.papai.grana.model.StandardDiscTestResult;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DiscTestValidator implements ConstraintValidator<DiscTest, StandardDiscTestResult> {

    @Override
    public void initialize(DiscTest constraintAnnotation) {
        // nothing needs to be extracted from the annotation
    }

    @Override
    public boolean isValid(StandardDiscTestResult value, ConstraintValidatorContext context) {
        return value == null || value.getMinThickness() <= value.getMaxThickness();
    }
}
