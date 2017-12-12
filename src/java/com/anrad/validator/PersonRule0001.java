/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anrad.validator;

import com.anrad.person.Person;
import javax.ejb.Stateless;

@Stateless
@RuleAnnotation (
        //errMsg = "RecordRule0001 have not realized yet",
        //group = RuleGroup.DEFAULT
        error = RuleError.PERSON_ERR_001
)

public class PersonRule0001 
        extends AbstractRule<Person>
        implements Rule<Person>

{

    @Override
    protected void execute(Person t) throws RuleException {
        //this.logging("PersonRule0001 not supported yet. Record =  " + t.toString());
        throw new RuleException("Rule is not supported yet");
    }
    
}
