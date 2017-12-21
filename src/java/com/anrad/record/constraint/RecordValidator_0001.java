package com.anrad.record.constraint;

import com.anrad.dbo.StoreService;
import com.anrad.record.Record;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RecordValidator_0001 implements ConstraintValidator<RecordConstraint_0001, Record> {
    
    @Inject
    //@Named("recordStore")
    //private RecordStore recordStore;
    private StoreService<Record, String> recordStore;
    
    @Override
    public void initialize(RecordConstraint_0001 constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        
    }

    @Override
    public boolean isValid(Record value, ConstraintValidatorContext context) {
        if (value == null)  return true;
        
        for (Record r : recordStore.get()) {
            if (r.getName().equals(value.getName())) return false;
        }
        return true;
    }
    
}