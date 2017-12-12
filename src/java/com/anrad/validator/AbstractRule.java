package com.anrad.validator;

import com.anrad.log.LogRecord;
import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.inject.Inject;

public abstract class AbstractRule<T> implements Rule<T> {
    
    //private String msg;
    //private RuleGroup group;
    private boolean active = false;
    private RuleError error;
    
     
    @PostConstruct
    protected void init() {
        this.logging("init");
        if (this.getClass().getAnnotation(RuleAnnotation.class) != null) {
            error = this.getClass().getAnnotation(RuleAnnotation.class).error();
            //msg = this.getClass().getAnnotation(RuleAnnotation.class).errMsg();
            //group = this.getClass().getAnnotation(RuleAnnotation.class).group();
            active = true;
            this.logging("Rule is initialized: " + this.toString());
        } else {
            this.logging("Validation rule does not have annotation");
            //throw new RuntimeException("Validation rule does not have annotation");
        }
    }
    
    protected abstract void execute(T t) throws RuleException;
    
    @Override
    public RuleResult apply(T t) {
        this.logging("Applying rule for: " + t.toString());
        RuleResult r;
        try {
            execute(t);
            r = new RuleResult(this.getError(), "Applying rule result is true", true);
            this.logging("Applying rule result is true");
        } catch (RuleException ex) { 
            r = new RuleResult(this.getError(), "Applying rule result is false: " + ex.getMessage(), false);
            this.logging("Applying rule result is false");
        }
        return r;
    }
    
    @Override
    public String toString() {
        return 
                "Rule class = "+ this.getClass().getSimpleName()
                + "; error" + error
                ;
    }
    
    @Inject 
    Event<LogRecord> logger;
    
    protected void logging(String msg) {
        logger.fire(new LogRecord(this.getClass().getSimpleName(), msg));
    }
    
    @Override
    public RuleError getError() {
        return error;
    }

    public boolean isActive() {
        return active;
    }

}
