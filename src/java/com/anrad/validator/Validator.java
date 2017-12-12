
package com.anrad.validator;

import java.util.List;


public interface Validator<T> {
    List<RuleResult> validate(T t, RuleGroup g);
    
}
