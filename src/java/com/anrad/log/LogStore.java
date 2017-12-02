package com.anrad.log;

import com.anrad.dbo.AbstractStoreService;
import com.anrad.record.ActionEvent;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.event.Observes;

@Startup
@Singleton

public class LogStore extends AbstractStoreService<LogRecord, String> {
    public LogStore() {
        super();
    }
    
    @PostConstruct
    void init() {
        this.put(new LogRecord("LogStore", "log store is started"));
    }
    
    public void acceptEvent(@Observes LogRecord r) {
        this.put(r);
    }
}
