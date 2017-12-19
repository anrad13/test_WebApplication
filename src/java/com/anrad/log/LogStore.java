package com.anrad.log;

import com.anrad.dbo.AbstractStoreService;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

//@Startup
//@Singleton
@ApplicationScoped


public class LogStore extends AbstractStoreService<LogRecord, String> {
    
    @PostConstruct
    void init() {
        this.put(new LogRecord("LogStore", "log store is started"));
    }
    
    public void acceptEvent(@Observes LogRecord r) {
        this.put(r);
    }
}
