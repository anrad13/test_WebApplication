
package com.anrad.record;


public class RecordDTO {
    
    private String id;
    private String name;
    private String description;
    
    public RecordDTO() {}
    
    public RecordDTO(String name, String desc) {
        this();
        this.name = name;
        this.description = desc;
    }
    
    public RecordDTO(Record recordPersistence) {
        this();
        this.id = recordPersistence.getId();
        this.name = recordPersistence.getName();
        this.description = recordPersistence.getDescription();
    }
    
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public void setName(String n) { this.name = n; }
    public String getName() {return name; }
    
    public void setDescription(String d) { this.description = d; }
    public String getDescription() {return this.description; }

}
