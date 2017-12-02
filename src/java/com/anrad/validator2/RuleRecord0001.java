/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anrad.validator2;

import com.anrad.dbo.Storeable;
import com.anrad.record.Record;
import javax.ejb.Stateless;

@Stateless

@RuleAnnotation (
        errMsg = "Validation RuleRecord0001 failed",
        dto = Record.class,
        group = RuleGroup.DEFAULT
)

public class RuleRecord0001
    extends AbstractRule
    implements Rule
{

    @Override
    public void apply(Storeable dto) throws RuleException {
        throw new RuleException("Rule not realised: " 
                + this.toString()
                + "; object id = " + dto.getId());
    }
    
}
