package com.anrad.validator;

import com.anrad.record.RecordDTO;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

@Startup
@Stateless
//@Default
@ValidatorRuleError( errMsg = "ADD Record validation fails")

@ValidatorRuleGroup (group = ValidatorGroup.CREATE)

public class RecordAddValidatorRule 
        extends AbstractValidatorRule<RecordDTO>
        implements ValidatorRule<RecordDTO>
{

 
    @Override
    public void apply(RecordDTO t) throws ValidationRuleException {
        logging(this.getClass().getSimpleName()  + ": " + "rule have not implemented yet");
        throw new ValidationRuleException(getErrMsg() + ": " + "rule have not implemented yet");
    }
    
}
