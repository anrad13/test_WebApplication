package com.anrad.log;

import com.anrad.dbo.Storeable;
import java.time.LocalDateTime;
import java.util.UUID;


public class LogRecord implements Storeable<String>{
    private String id;
    private String t;
    private String name;
    private String msg;

    public LogRecord(String name, String msg) {
        id = UUID.randomUUID().toString();
        t = LocalDateTime.now().toString();
        this.name = name;
        this.msg = msg;
    }
    
    @Override
    public String getId() {
        return id;
    }

    public String getT() {
        return t;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    
   
    
    
    
}
