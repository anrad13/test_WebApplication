package com.anrad.validator;

import com.anrad.log.LogRecord;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;

public abstract class AbstractValidatorRule<T> implements ValidatorRule<T> {
    
    private String errMsg = "Validation rule does not have ValidatorRuleAnnotation";
    
    private ValidatorGroup group = ValidatorGroup.DEFAULT;
    
    protected String getErrMsg() {
        return errMsg;
    }
    
    @Inject 
    Event<LogRecord> logger;
    
    @PostConstruct
    protected void init() {
        this.logging("init");
        if (this.getClass().getAnnotation(ValidatorRuleError.class) != null) {
            errMsg = this.getClass().getAnnotation(ValidatorRuleError.class).errMsg();
        } else {
            this.logging("Validation rule does not have ValidatorRuleAnnotation");
        }
        
        if (this.getClass().getAnnotation(ValidatorRuleGroup.class) != null) {
            group = this.getClass().getAnnotation(ValidatorRuleGroup.class).group();
            this.logging("Validation rule set ValidatorRuleGroup as " + group);
        } else {
            this.logging("Validation rule does not have ValidatorRuleGroup");
        }
    }
    
    protected void logging(String msg) {
        logger.fire(new LogRecord(this.getClass().getSimpleName(), msg));
    }
    
    @Override
    public abstract void apply(T t) throws ValidationRuleException; 
    
       
}
