package com.anrad.record.constraint;


import com.anrad.record.Record;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@Dependent
public class RecordConstraintValidator {
    
    @Inject   
    private ValidatorFactory vf;
    
    public List<String> validate(Record r, Class<?>... groups) {
        List<String> errors = new ArrayList<>();
        Validator validator = vf.getValidator();
        
        Set<ConstraintViolation<Record>> constraints = validator.validate(r, groups);
        
        for(ConstraintViolation<Record> c :  constraints) {
            String s = "Validation error: " 
                    /*"Group = " + c.getConstraintDescriptor().getGroups().stream()
                            .map((Class clazz)->{return clazz.getSimpleName();})
                            .collect(Collectors.joining("(",";",")"))*/
                    + "msg = " + c.getMessage()
                    ;
            errors.add(s);
        }
        
        return errors;
    }
    
}
