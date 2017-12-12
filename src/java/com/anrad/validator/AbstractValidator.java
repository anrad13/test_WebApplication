/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anrad.validator;

import com.anrad.log.LogRecord;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;


public abstract class AbstractValidator<T>
        implements Validator<T>
{
    
    @Inject @Any
    private Instance<Rule<T>> rl;
    
    //private final Map<RuleGroup,Set<Rule<T>>> rm = new HashMap<>();
    // Ingect by producer
    //@Inject @Default
    //private Map<RuleGroup,Set<Rule<T>>> rm;
    
    @Inject @Default
    private Map<RuleError,Rule<T>> rules;
    
    
    /*@Override
    public List<RuleResult> validate2(T t, RuleGroup g) {
        List<RuleResult> m = new ArrayList<>();
        logging("Try to validate object = " + t.getClass().getName());
        if (rm.containsKey(g)) {
            logging("Applying rule for group = " + g);
            for(Rule<T> r : rm.get(g)) {
                //try { 
                    RuleResult res = r.apply(t); 
                    m.add(res);
                //} catch (Exception e) {
                //    logging("Rule exception. Rule = " + r.toString() + "; msg = " +  e.getMessage());
                //    m.add(e.getMessage());
                //}
            }
        } else {
            logging("No rule was founded for group = " + g);
        }
        
        return m;
    }*/
    
    @Override
    public List<RuleResult> validate(T t, RuleGroup g) {
        List<RuleResult> m = new ArrayList<>();
        logging("Try to validate object = " + t.getClass().getName() + ", group = " + g);
        for (RuleError err: rules.keySet()) {
            if (err.getErrGroup().equals(g)) {
                logging("Try to apply rule = " + rules.get(err).toString());
                RuleResult res = rules.get(err).apply(t);
                m.add(res);
            }
        }
        return m;
    }
    
    @Inject 
    Event<LogRecord> logger;
    protected void logging(String msg) {
        logger.fire(new LogRecord(this.getClass().getSimpleName(), msg));
    }
    
    
    
}
