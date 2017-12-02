/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anrad.validator4;

import com.anrad.log.LogRecord;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

public abstract class AbstractRuleProducer<T> {
    @Inject @Any
    private Instance<Rule<T>> rl;
    
    //private final Map<RuleGroup,Set<Rule<T>>> rm = new HashMap<>();
    
    
     protected Map<RuleGroup,Set<Rule<T>>> produce() {
        logging("Init");
        Map<RuleGroup,Set<Rule<T>>> rm = new HashMap<>();
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
        return rm;
    }
    
    
    @Inject 
    Event<LogRecord> logger;
    protected void logging(String msg) {
        logger.fire(new LogRecord(this.getClass().getSimpleName(), msg));
    }
    
}
