package com.anrad.person;

import com.anrad.dbo.AbstractStoreService;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;

//@Startup
//@Singleton
@ApplicationScoped

public class PersonStore extends AbstractStoreService<Person,UUID> {}
