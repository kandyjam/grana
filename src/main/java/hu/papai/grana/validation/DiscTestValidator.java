package hu.papai.grana.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DiscTestValidator implements ConstraintValidator<DiscTest, hu.papai.grana.model.DiscTest> {

    @Override
    public void initialize(DiscTest constraintAnnotation) {
        // nothing needs to be extracted from the annotation
    }

    @Override
    public boolean isValid(hu.papai.grana.model.DiscTest value, ConstraintValidatorContext context) {
        return value == null || value.getMinThickness() <= value.getMaxThickness();
    }
}
