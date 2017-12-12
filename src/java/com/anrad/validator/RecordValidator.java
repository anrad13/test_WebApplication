
package com.anrad.validator;

import com.anrad.record.Record;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

//@Stateless
//@Named
//@RequestScoped

	
@Dependent

public class RecordValidator
        extends AbstractValidator<Record>
        implements Validator<Record>
{
    
}
