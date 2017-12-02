/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anrad.validator;

import com.anrad.person.Person;
import com.anrad.record.RecordDTO;
import javax.ejb.Stateless;

/**
 *
 * @author Radoselskiy
 */
@Stateless
public class BeanBSimpleInterface 
        extends AbstractSimpleInterface<RecordDTO>
        implements SimpleInterface<RecordDTO> {

    @Override
    public String apply() {
        return this.getClass().getName() + " - Record; Generic = " + getGenericParameterClass(this.getClass(),0);
    }
    
}
