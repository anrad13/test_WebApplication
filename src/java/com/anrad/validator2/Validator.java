package com.anrad.validator2;

import com.anrad.dbo.Storeable;
import java.util.List;

/**
 *
 * @author Radoselskiy
 */
public interface Validator {
    List<String> validate(Storeable dto, RuleGroup group);
    
}
