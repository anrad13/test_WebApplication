/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anrad.validator4;

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
    @Inject @Default
    private Map<RuleGroup,Set<Rule<T>>> rm;
    
    //@PostConstruct
    /*
    private void init() {
        logging("Init");
        rl.forEach((Rule<T> r) -> {
            logging("Found rule: " + r.toString());
            RuleGroup g = r.getGroup();
            
            if (g != null) { 
                if (! rm.containsKey(g)) {
                    rm.put(g, new HashSet<>());
                }
                rm.get(g).add(r);
                logging("rule put to group = " + g + ": " + r.toString());
            }
            else {
                logging("rule does not have group " + r.toString());
            }
         });
    }
    */
    
    @Override
    public List<String> validate(T t, RuleGroup g) {
        List<String> m = new ArrayList<>();
        logging("Try to validate object = " + t.getClass().getName());
        if (rm.containsKey(g)) {
            logging("Applying rule for group = " + g);
            for(Rule<T> r : rm.get(g)) {
                try { 
                    r.apply(t); 
                } catch (Exception e) {
                    logging("Rule exception. Rule = " + r.toString() + "; msg = " +  e.getMessage());
                    m.add(e.getMessage());
                }
            }
            
            //rm.get(g).forEach((Rule<T> r) -> {
                //try {
                //    r.apply(t);
                //} catch (RuleException ex) {
                    //logging("Rule exception. Rule = " + r.toString() + "; msg = " +  ex.getMessage());
                //}
                //logging("Apply rule success: " + r.toString());
            //});
        } else {
            logging("No rule was founded for group = " + g);
        }
        
        return m;
    }
    
    @Inject 
    Event<LogRecord> logger;
    protected void logging(String msg) {
        logger.fire(new LogRecord(this.getClass().getSimpleName(), msg));
    }
    
    
    
}
