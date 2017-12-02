/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anrad.validator;

import com.anrad.record.Record;
import java.util.Map;
import java.util.Set;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;


public class RecordRuleProducer
       extends AbstractRuleProducer<Record>
{
    @Override
    @Produces @Default
    public Map<RuleGroup,Set<Rule<Record>>> produce() {
        return super.produce();
    }

}

