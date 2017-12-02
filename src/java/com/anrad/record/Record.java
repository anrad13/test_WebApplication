package com.anrad.record;

import com.anrad.dbo.Storeable;
import java.util.UUID;

public class Record implements Storeable<String> {
    private String id;
    private String name;
    private String description;
    
    public Record() {
        id = UUID.randomUUID().toString();
    }
    
    public Record(String n, String d) {
        this();
        name = n;
        description = d;
    }
    
    @Override
    public String getId() { return id; }
    
    public void setName(String n) { this.name = n; }
    public String getName() {return name; }
    
    public void setDescription(String d) { this.description = d; }
    public String getDescription() {return this.description; }
    
    @Override
    public String toString() {
        return "id = " + id + "; name = " + name;
    }
    
}
