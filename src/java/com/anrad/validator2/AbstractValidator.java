/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anrad.validator2;

import com.anrad.dbo.Storeable;
import com.anrad.log.LogRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 *
 * @author Radoselskiy
 */
public abstract class AbstractValidator implements Validator {
    
    private Class<? extends Storeable> dtoClazz;
    
    private Map<RuleGroup,List<Rule>> ruleMap = new HashMap<>();
    
    @Inject 
    Event<LogRecord> logger;
    
    @Inject 
    @Any 
    private Instance<Rule> rules;

@Inject @ProvidedRules
private String prefix;
@Inject @ProvidedRules
private int editorNumber;
@Inject @ProvidedRules
private List<Rule> rlist;
    
    //@PostConstruct
    protected void init() {
        this.logging("init: prefix = " + prefix + " editor number = " + editorNumber );
        rlist.forEach(r->{ this.logging("init: rule provided: " + r.toString());});
        
        if (this.getClass().getAnnotation(DTOAnnotation.class) != null) {
            dtoClazz = this.getClass().getAnnotation(DTOAnnotation.class).dto();
            this.logging("Handler is annotated by dto class = " + dtoClazz.getSimpleName());
        } else {
            this.logging("Handler does not have annotation");
            return;
        }
        
        //rules.forEach(r -> {
        rlist.forEach(r -> {
            this.logging("Found rule: " + r.toString());
            if (r.getDtoClass() == dtoClazz) {
                if (ruleMap.get(r.getGroup()) == null) {
                    ruleMap.put(r.getGroup(), new ArrayList<>());
                }
                ruleMap.get(r.getGroup()).add(r);
                this.logging("Rule put to map: " + r.toString());
            }
        }
        );
        
    }

   @Override
    public List<String> validate(Storeable dto, RuleGroup g) {
        this.logging("Try to validate. Class = " +  dto.getClass().getSimpleName() + "; Group = " + g);
        List<String> msgList = new ArrayList<>();
        
        List<Rule> rl = ruleMap.get(g);
        //rules.forEach(r -> {this.logging("Present rule = " + r.getClass().getName());});
        if (rl == null) {
            this.logging("Rule not found for group = " + g);
            msgList.add("Rule not found for group = " + g);
            return msgList;
        }
        
        for (Rule r : rl) {
            try {
                r.apply(dto);
            } catch (RuleException ex) {
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
