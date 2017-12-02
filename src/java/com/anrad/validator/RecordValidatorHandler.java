package com.anrad.validator;

import com.anrad.record.RecordDTO;
import javax.ejb.Startup;
import javax.ejb.Stateless;

@Startup
@Stateless
public  class RecordValidatorHandler extends AbstractValidatorHandler<RecordDTO> {
    public RecordValidatorHandler() {super();}

    
    
}
