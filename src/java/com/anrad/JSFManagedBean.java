/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anrad;

import com.anrad.person.Person;
import com.anrad.person.PersonDTO;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Radoselskiy
 */
@Named(value = "jSFManagedBean")
//@RequestScoped
@Stateless
public class JSFManagedBean {

    
    public JSFManagedBean() {
    }
     
    private String name = "JSFManagedBean";
    
     
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String apply() {
        String res = "Apply result:";        
        //name = "Apply result: " + name + "\n";
        //return null;
        //return "Apply result: " + name;
        
        PersonDTO person = new PersonDTO( new Person("Person name 1", "Person descr 1")  );
        res = res + "Person: Name = " + person.getName() + " UUID = " + person.getUuid();
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, new FacesMessage("Simple faces Message for uuid = " + person.getUuid()));
        
        return res;
    } 

}
