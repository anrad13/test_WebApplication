package com.anrad.validator;

import com.anrad.person.Person;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;

//@Stateless

@Dependent

@RuleAnnotation (
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
