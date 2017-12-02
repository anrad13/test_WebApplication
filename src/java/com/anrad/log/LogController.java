/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anrad.log;

import com.anrad.record.RecordDTO;
import com.anrad.record.Record;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "logController")
@RequestScoped

public class LogController {
    @Inject
    private LogStore logStore;
    
    private LogDTO logRecord = new LogDTO();

    public LogDTO getLogRecord() {
        return logRecord;
    }

    public void setLogRecord(LogDTO logRecord) {
        this.logRecord = logRecord;
    }
    
    public List<LogDTO> doFindAll() {
        List<LogDTO> l = new ArrayList<>(); 
        List<LogRecord> recordList = logStore.get();
        recordList.stream().map(
                (r) -> { return new LogDTO(r); }
        ).forEachOrdered((dto) -> {
            l.add(dto);
        });
        
        //FacesContext facesContext = FacesContext.getCurrentInstance();
        //facesContext.addMessage("recordList", new FacesMessage("Record count = " + recordList.size()));
        
        return l;
    }
    
}
