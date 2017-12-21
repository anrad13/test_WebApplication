package com.anrad.record.constraint;

import com.anrad.record.Record;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RecordValidator_0002 implements ConstraintValidator<RecordConstraint_0002, Record> {

    @Override
    public void initialize(RecordConstraint_0002 constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        
    }

    @Override
    public boolean isValid(Record value, ConstraintValidatorContext context) {
        //if (value == null)  return true;
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("Error 0002-1").addConstraintViolation();
        context.buildConstraintViolationWithTemplate("Error 0002-2").addConstraintViolation();
        context.buildConstraintViolationWithTemplate("Error 0002-3").addConstraintViolation();
        return false;
    }
    
}