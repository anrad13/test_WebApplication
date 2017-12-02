/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anrad.person;

import java.util.UUID;

public class PersonDTO {
    
    private String name;
    private String description;
    private UUID uuid;

    public PersonDTO() {
    
    }
    
    public PersonDTO(Person person) {
        this();
        this.uuid = person.getId();
        this.name = person.getName();
        this.description = person.getDescription();
    }
    
    public UUID getUuid() {
        return uuid;
    }
    
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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
