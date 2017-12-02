/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anrad.validator;

import com.anrad.record.RecordDTO;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

@Startup
@Stateless
//@Default
@ValidatorRuleError( errMsg = "DELETE Record validation fails")

@ValidatorRuleGroup (group = ValidatorGroup.DELETE)

public class RecordDeleteValidatorRule 
        extends AbstractValidatorRule<RecordDTO> 
        implements ValidatorRule<RecordDTO>
{

 
    @Override
    public void apply(RecordDTO t) throws ValidationRuleException {
        logging(this.getClass().getSimpleName() + ": " + "rule have not implemented yet");
        throw new ValidationRuleException(getErrMsg() + ": " + "rule have not implemented yet");
    }
    
}
