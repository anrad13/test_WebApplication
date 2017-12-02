/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anrad.validator3;

import com.anrad.person.Person;
import javax.ejb.Stateless;

@Stateless
public class PersonValidator 
        extends AbstractValidator<Person>
        implements Validator<Person>
        
{

    @Override
    public void validate(Person t) {
        logging("Validator not supported yet.");
    }
    
}
