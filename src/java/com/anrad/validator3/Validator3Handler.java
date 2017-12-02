/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anrad.validator3;

import com.anrad.log.LogRecord;
import com.anrad.record.Record;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

@Stateless
@Startup
//@Dto(Record.class)
public class Validator3Handler {
    
    @Inject @Default //@Dto
    private List<Validator<Record>> vl;
    
    @PostConstruct
    private void init() {
        logging("Init");
       
    }
    
    public void validate() {
         vl.forEach( r -> { 
             this.logging("Try validator: " + r.getClass()); 
             r.validate(null);
         });
    }
    
    @Inject 
    private Event<LogRecord> logger;

    protected void logging(String msg) {
        logger.fire(new LogRecord(this.getClass().getSimpleName(), msg));
    }
     
}
