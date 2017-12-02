
package com.anrad.validator;

import com.anrad.record.RecordDTO;
import javax.ejb.Stateless;

@Stateless
public class BeanASimpleInterface
        extends AbstractSimpleInterface<RecordDTO>
        implements SimpleInterface<RecordDTO> {

    @Override
    public String apply() {
        return this.getClass().getName()+ " - Record; Generic = " + getGenericParameterClass(this.getClass(),0);
    }
    
}
