/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anrad.validator3;

import com.anrad.record.Record;
import javax.ejb.Stateless;

@Stateless
public class RecordValidator 
        extends AbstractValidator<Record>
        implements Validator<Record>
        
{

    @Override
    public void validate(Record t) {
        logging("Validator not supported yet.");
    }
    
}
