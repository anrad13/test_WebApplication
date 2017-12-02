/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anrad.validator2;

import com.anrad.log.LogRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

public class RuleProducerImpl {
    private Map<RuleGroup,List<Rule>> ruleMap = new HashMap<>();
    
    @Inject 
    private Event<LogRecord> logger;
    
    @Inject 
    @Any 
    private Instance<Rule> rules;
    
    @Produces @ProvidedRules
    public List<Rule> rules() {
        List<Rule> l = new ArrayList<>();
        rules.forEach(r -> {
            this.logging("Found rule: " + r.toString());
            l.add(r);
        });
        return l;
    }
    
    /*@PostConstruct
    protected void init() {
        this.logging("init");
        
        if (this.getClass().getAnnotation(DTOAnnotation.class) != null) {
            dtoClazz = this.getClass().getAnnotation(DTOAnnotation.class).dto();
            this.logging("Handler is annotated by dto class = " + dtoClazz.getSimpleName());
        } else {
            this.logging("Validation rule does not have annotation");
            return;
        }

        rules.forEach(r -> {
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
        
    } */
    
    
    
    
    @Produces @ProvidedRules
    private String prefix13digits = "13-";
    @Produces @ProvidedRules
    private int editorNumber = 84356;
    
    
    protected void logging(String msg) {
        logger.fire(new LogRecord(this.getClass().getSimpleName(), msg));
    }

}