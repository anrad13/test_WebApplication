/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anrad.validator3;

import com.anrad.log.LogRecord;
import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 *
 * @author Radoselskiy
 */
public abstract class AbstractValidator<T extends Object> implements Validator<T> {
    @Inject 
    private Event<LogRecord> logger;

    
     protected void logging(String msg) {
        logger.fire(new LogRecord(this.getClass().getSimpleName(), msg));
    }
     
}
