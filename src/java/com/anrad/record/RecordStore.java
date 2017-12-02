package com.anrad.record;

import com.anrad.dbo.AbstractStoreService;
import com.anrad.validator4.RecordValidator;
import com.anrad.validator4.RuleGroup;
import com.anrad.validator4.Validator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

@Startup
@Singleton

public class RecordStore extends AbstractStoreService<Record, String> {
    
    //@Inject
    //@Default
    //@DTOAnnotation(dto = Record.class)
    //Validator validator;
    
    //@Inject
    //Validator3Handler vh;
    
    @Inject 
    Validator<Record> validator;
    
    public RecordStore() {
        super();
    }
    
    @PostConstruct
    void init() {
        this.put(new Record("Name 1", "Description 1"));
        this.put(new Record("Name 2", "Description 2"));
        this.put(new Record("Name 3", "Description 3"));
        this.put(new Record("Name 4", "Description 4"));
    }
    
    @Override
    public void put(Record r) {
        validator.validate(r, RuleGroup.DEFAULT);
        //vh.validate();
        super.put(r);
    }
    
}
