/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anrad.validator;

import com.anrad.record.Record;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

//@Stateless
//@RequestScoped
	
@Dependent

@RuleAnnotation (error = RuleError.RECORD_ERR_002)

public class RecordRule0002 
        extends AbstractRule<Record>
        implements Rule<Record>

{

    @Override
    protected void execute(Record t) throws RuleException {
        throw new RuleException("Rule is not supported yet");
    }
    
}