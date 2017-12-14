package com.anrad;

import com.anrad.log.LogRecord;
import com.anrad.record.RecordDTO;
import com.anrad.record.Record;
import com.anrad.record.RecordStore;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "recordController")
@RequestScoped

public class RecordController {
    
    @Inject
    private RecordStore recordStore;
    
    private RecordDTO record = new RecordDTO();
    
    public void setRecord(RecordDTO rDO) { this.record = rDO;}
    public RecordDTO getRecord() {return this.record;}
    
    public List<RecordDTO> doFindAll() {
        List<RecordDTO> recordDOList = new ArrayList<>(); 
        List<Record> recordList = recordStore.get();
        recordList.stream().map((r) -> { return new RecordDTO(r); }
        ).forEachOrdered((rDO) -> {
            recordDOList.add(rDO);
        });
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage("recordList", new FacesMessage("Record count = " + recordList.size()));
        
        return recordDOList;
    }
    
    public void doFindById() {
        if (record != null) {
            Record r = recordStore.get(record.getId());
            if (r != null) {
                record = new RecordDTO(r);
            }
        }
    }
    
    @Inject
    private Event<LogRecord> logger;
    
    public String doCreate() {
        
        //#TODO validate
               
        if (record.getName() != null && record.getName().length()>0) {
            
            recordStore.put(new Record(record.getName(),record.getDescription()));
            logger.fire(new LogRecord(this.getClass().getSimpleName(),"Record was added to record store"));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Record was created"));
            record = new RecordDTO();
        }
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Record can not be created. Name is empty"));
        } 
        //p = new Person();
        return null;
    }
    
    public String doDelete(String id) {
        recordStore.del(id);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Record was deleted. id = " + id));
        return "listRecord.xhtml";
    }

}
