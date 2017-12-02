package com.anrad.person;

import com.anrad.dbo.Storeable;
import java.util.UUID;


public class Person implements Storeable<UUID> {
    
    private UUID uuid ;
    private String name;
    private String description;
    
    public Person() { 
        uuid = UUID.randomUUID();
    }
    
    public Person(String name, String desc) {
        this();
        this.name = name;
        this.description = desc;
    }
    
    @Override
    public UUID getId() {
        return uuid;
    }
    
     
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
  
}
