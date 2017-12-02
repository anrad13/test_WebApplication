/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anrad.validator;

import com.anrad.record.Record;
import javax.ejb.Stateless;

@Stateless
@RuleAnnotation (
        errMsg = "RecordRule0002 have not realized yet",
        group = RuleGroup.DEFAULT
)

public class RecordRule0002 
        extends AbstractRule<Record>
        implements Rule<Record>

{

    @Override
    public void apply(Record t) throws Exception {
        this.logging("RecordRule0002 not supported yet Record =  " + t.toString());
        throw new RuleException("Rule is not supported yet");
    }
    
}