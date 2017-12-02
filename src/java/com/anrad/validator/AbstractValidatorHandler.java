package com.anrad.validator;

import com.anrad.log.LogRecord;
import com.anrad.person.Person;
import com.anrad.record.RecordDTO;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

public abstract class AbstractValidatorHandler<T> implements ValidatorHandler<T>{
    
    public AbstractValidatorHandler() {}
    
    private List<String> msgList = new ArrayList<>();
    
    @Inject 
    Event<LogRecord> logger;
    
    @Inject 
    @Any 
    //@ValidatorRuleGroup (group = ValidatorGroup.CREATE)
    private Instance<ValidatorRule<T>> rules;
    
    private Map<ValidatorGroup,List<ValidatorRule<T>>> ruleMap = new HashMap<>();
    
    
    @PostConstruct
    protected void init() {
        this.logging("init");
        rules.forEach(r -> {
            
            this.logging("Found rule = " + r.getClass().getName());
            // ---------- Mock gealization for DEFAULT
            if (ruleMap.get(ValidatorGroup.DEFAULT) == null) {
                    ruleMap.put(ValidatorGroup.DEFAULT, new ArrayList<>());
            }
            ruleMap.get(ValidatorGroup.DEFAULT).add(r);
            this.logging("Rule = " + r.getClass().getName() + " put into group = " + ValidatorGroup.DEFAULT);
            
            /*
            for( Annotation a : r.getClass().getAnnotations()) {
                this.logging("For rule = " + r.getClass().toGenericString() + " found annotation = " + a.toString());
            }
            
            if (r.getClass().getDeclaredAnnotation(ValidatorRuleGroup.class) != null) {
                ValidatorGroup group = r.getClass().getAnnotation(ValidatorRuleGroup.class).group();
                if (ruleMap.get(group) == null) {
                    ruleMap.put(group, new ArrayList<>());
                }
                ruleMap.get(group).add(r);
                this.logging("Rule = " + r.getClass().getName() + " put into group = " + group);
            }
            */
            }
            );
    }
    
    @Override
    public List<String> validate(T t, ValidatorGroup g) {
        this.logging("Try to validate. Class = " +  t.getClass().getSimpleName() + "; Group = " + g);
        msgList = new ArrayList<>();
        
        List<ValidatorRule<T>> rl = ruleMap.get(g);
        //rules.forEach(r -> {this.logging("Present rule = " + r.getClass().getName());});
        if (rl == null) {
            this.logging("Rule not found for group = " + g);
            return msgList;
        }
        
        for (ValidatorRule<T> r : rl) {
            try {
                r.apply(t);
            } catch (ValidationRuleException ex) {
                this.logging("Validation error: " +  ex.getMessage());
                msgList.add("Validation error: " +  ex.getMessage());
            }
        }
        
        msgList.add("Validator handler is not completed");
        return msgList;
    }
    
    protected void logging(String msg) {
        logger.fire(new LogRecord(this.getClass().getSimpleName(), msg));
    }

}
