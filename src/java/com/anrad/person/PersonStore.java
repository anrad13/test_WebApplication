package com.anrad.person;

import com.anrad.dbo.AbstractStoreService;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton

public class PersonStore extends AbstractStoreService<Person,UUID> {
    
    @PostConstruct
    void init() {
        this.put(new Person("Name 1", "Description 1"));
        this.put(new Person("Name 2", "Description 2"));
        this.put(new Person("Name 3", "Description 3"));
        this.put(new Person("Name 4", "Description 4"));
    }
        
}
