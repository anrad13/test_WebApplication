/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anrad.log;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

@Stateless
@Named("logHandlerImpl")
public class LogHandlerImpl 
        implements LogHandler
{

    @Inject 
    Event<LogRecord> logger;
    
    @Override
    public void logging(String s) {
        logger.fire(new LogRecord(this.getClass().getSimpleName(), s));
    }
    
}
