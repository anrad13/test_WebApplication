package com.anrad.validator4;

import com.anrad.log.LogRecord;
import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.inject.Inject;

public abstract class AbstractRule<T> implements Rule<T> {
    
    private String msg;
    private RuleGroup group;
    private boolean active = false;
    
     
    @PostConstruct
    protected void init() {
        this.logging("init");
        if (this.getClass().getAnnotation(RuleAnnotation.class) != null) {
            msg = this.getClass().getAnnotation(RuleAnnotation.class).errMsg();
            group = this.getClass().getAnnotation(RuleAnnotation.class).group();
            active = true;
            this.logging("Rule is initialized: " + this.toString());
        } else {
            this.logging("Validation rule does not have annotation");
        }
    }
    
    @Override
    public String toString() {
        return "Rule class = "+ this.getClass().getSimpleName()
                + "; msg = '" + msg 
                +"'; group = " + group 
                ;
                
    }
    
    @Inject 
    Event<LogRecord> logger;
   protected void logging(String msg) {
        logger.fire(new LogRecord(this.getClass().getSimpleName(), msg));
    }
    
    protected String getMsg() {
        return msg;
    }

    @Override
    public RuleGroup getGroup() {
        return group;
    }

    public boolean isActive() {
        return active;
    }

}
