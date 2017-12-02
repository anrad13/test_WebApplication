package com.anrad;

import com.anrad.person.Person;
import com.anrad.person.PersonDTO;
import com.anrad.person.PersonStore;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;


@Named(value = "personController")
@RequestScoped
//@SessionScoped

public class PersonController  
{
    
    @Inject
    private PersonStore personStore;
    
    private PersonDTO p = new PersonDTO();
    
    public String doCreatePerson() {
        personStore.put( new Person(p.getName(), p.getDescription())); 
        return null;
    }
    public void doFindPersonById() {
        Person person = personStore.get(p.getUuid());
        p = new PersonDTO(person);
    }
    
    public List<PersonDTO> findAll() {
        //List<PersonDTO> l = new ArrayList<>();
        return this.personStore.get()
                .stream()
                .map((Person person) -> {return new PersonDTO(person);})
                .collect(Collectors.toList());
    }
    
    public PersonDTO getP() {
        return p;
    }
    
    public void setP(PersonDTO p) {
        this.p = p;
    }

}
