/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anrad.validator4;

import com.anrad.record.Record;
import javax.ejb.Stateless;

@Stateless
@RuleAnnotation (
        errMsg = "RecordRule0001 have not realized yet",
        group = RuleGroup.DEFAULT
)

public class RecordRule0001 
        extends AbstractRule<Record>
        implements Rule<Record>

{

    @Override
    public void apply(Record t) throws Exception {
        this.logging("RecordRule0001 not supported yet. Record =  " + t.toString());
        throw new RuleException("Rule is not supported yet");
    }
    
}
