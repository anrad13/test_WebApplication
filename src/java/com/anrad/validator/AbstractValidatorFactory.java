package com.anrad.validator;

import com.anrad.log.LogRecord;
import com.anrad.person.Person;
import com.anrad.record.RecordDTO;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;


public abstract class AbstractValidatorFactory<T> {

    @Inject 
    Event<LogRecord> logger;
     
    @Inject
    @Any
    private Instance<ValidatorRule<T>> rules;
    
    @Produces 
    public List<ValidatorRule<T>> getValidator(InjectionPoint injectionPoint) {
        List<ValidatorRule<T>> l = new ArrayList<>();
        rules.forEach(r -> {
            this.logging("Found rule = " + r.getClass().getName());
            l.add(r);
            }
        );
        return l;
   }
    
   protected void logging(String msg) {
        logger.fire(new LogRecord(this.getClass().getSimpleName(), msg));
    }


}
