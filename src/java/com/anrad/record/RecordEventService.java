
package com.anrad.record;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@Stateless
@Startup
public class RecordEventService {

    @Inject
    private RecordStore recordStore;
    
    @PostConstruct
    private void init() {
        //recordStore.put( new RecordPersistence("RecordEventService", " "));
    }
    
    public <T> void acceptEvent(@Observes ActionEvent<T> e) {
        T t = e.get();
        
        String name = "acceptEvent";
        String descr = "Class name = " + t.getClass().getName();
        recordStore.put( new Record(name,descr));
    }
 
    public void acceptRecordEvent(@Observes ActionEvent<RecordDTO> e) {
        RecordDTO t = e.get();
        
        String name = "acceptRecordEvent";
        String descr = "Class name = " + t.getClass().getName();
        recordStore.put( new Record(name,descr));
    }

   public void acceptRecordPersistEvent(@Observes ActionEvent<Record> e) {
        Record t = e.get();
        
        String name = "acceptRecordPersistEvent";
        String descr = "Class name = " + t.getClass().getName();
        recordStore.put( new Record(name,descr));
   }
     
    public void addRecord(@Observes RecordDTO record ) {
        recordStore.put( new Record(record.getName(),record.getDescription() + "; " + new Date().toString() ));
        //throw new RuntimeException("from event j,server");
    }
}
