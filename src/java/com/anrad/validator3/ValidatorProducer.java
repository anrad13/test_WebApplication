/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anrad.validator3;

import com.anrad.log.LogRecord;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

/**
 *
 * @author Radoselskiy
 */
public abstract class ValidatorProducer<T> {
    @Inject 
    private Event<LogRecord> logger;
    
    @Inject
    @Any
    private Instance<Validator<T>> vl;
    
    //@Produces @Default //@Dto
    protected List<Validator<T>> produce() {
        List<Validator<T>> l = new ArrayList<>();
        vl.forEach(r -> {
            this.logging("Found validator: " + r.getClass());
                l.add((Validator<T>) r);
        });
        return l;
    }
    
    
    protected void logging(String msg) {
        logger.fire(new LogRecord(this.getClass().getSimpleName(), msg));
    }
    
}
