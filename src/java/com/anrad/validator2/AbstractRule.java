/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anrad.validator2;

import com.anrad.dbo.Storeable;
import com.anrad.log.LogRecord;
import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.inject.Inject;


public abstract class AbstractRule implements Rule {
    
    private String msg;
    private Class<? extends Storeable> dto;
    private RuleGroup group;
    private boolean active = false;
    
    @Inject 
    Event<LogRecord> logger;
    
    @PostConstruct
    protected void init() {
        this.logging("init");
        if (this.getClass().getAnnotation(RuleAnnotation.class) != null) {
            msg = this.getClass().getAnnotation(RuleAnnotation.class).errMsg();
            group = this.getClass().getAnnotation(RuleAnnotation.class).group();
            dto = this.getClass().getAnnotation(RuleAnnotation.class).dto();
            active = true;
            this.logging("Rule is initialized: " + this.toString());
        } else {
            this.logging("Validation rule does not have annotation");
        }
    }
    
    public String toString() {
        return "Rule class = "+ this.getClass().getSimpleName()
                + "; msg = '" + msg 
                +"'; group = " + group 
                + "; dtoClazz = " + dto.getSimpleName();
                
    }
    
    protected void logging(String msg) {
        logger.fire(new LogRecord(this.getClass().getSimpleName(), msg));
    }
    
    protected String getMsg() {
        return msg;
    }

    @Override
    public Class<? extends Storeable> getDtoClass() {
        return dto;
    }

    @Override
    public RuleGroup getGroup() {
        return group;
    }

    public boolean isActive() {
        return active;
    }

}
