package com.anrad.validator2;

import com.anrad.record.Record;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

@Stateless
//@Default
@DTOAnnotation(dto = Record.class)
public class RecordValidator
        extends AbstractValidator
        implements Validator
{
    
}

