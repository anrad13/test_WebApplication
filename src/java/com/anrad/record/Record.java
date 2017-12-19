package com.anrad.record;

import com.anrad.dbo.Storeable;
import java.util.Objects;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Record other = (Record) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }
    
    
    
}
