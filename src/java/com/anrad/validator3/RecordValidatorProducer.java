/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anrad.validator3;

import com.anrad.record.Record;
import java.util.List;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;

public class RecordValidatorProducer
        extends ValidatorProducer<Record>
{
    @Produces @Default //@Dto
    public List<Validator<Record>> produce() {
        return super.produce();
    }

}
