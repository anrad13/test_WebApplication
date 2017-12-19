package com.anrad.record;

import com.anrad.dbo.AbstractStoreService;
import com.anrad.dbo.StoreService;
import com.anrad.log.LogRecord;
import com.anrad.validator.RuleGroup;
import com.anrad.validator.RuleResult;
import com.anrad.validator.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

//@Startup
//@Singleton
//@Named("recordStore")
@ApplicationScoped

public class RecordStore 
        extends AbstractStoreService<Record, String> 
        implements StoreService<Record, String>

{
    
    @Inject 
    Validator<Record> validator;
    
    public RecordStore() {
        super();
    }
    
    //@PostConstruct
    void init() {
        //this.put(new Record("Name 1", "Description 1"));
        //this.put(new Record("Name 2", "Description 2"));
        //this.put(new Record("Name 3", "Description 3"));
        //this.put(new Record("Name 4", "Description 4"));
    }
    
    @Override
    public void put(Record r) {
        //String result = validator.validate(r, RuleGroup.DEFAULT).stream().collect(Collectors.joining("\n"));
        List<RuleResult> resultList= validator.validate(r, RuleGroup.DEFAULT);
        List<String> resultString = new ArrayList<>();
        
        resultList.forEach((ruleResult) -> {
            resultString.add(ruleResult.toString());
        });
        
        String result = resultString.stream().collect(Collectors.joining("\n"));
        
        logging(result);
        super.put(r);
    }
    
    @Inject 
    Event<LogRecord> logger;
    protected void logging(String msg) {
        logger.fire(new LogRecord(this.getClass().getSimpleName(), msg));
    }
    
    //@Inject
    //LogHandlerImpl l;
    //LogHandler l;

}
