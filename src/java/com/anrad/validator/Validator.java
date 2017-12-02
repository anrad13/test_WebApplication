
package com.anrad.validator;

import java.util.List;


public interface Validator<T> {
    List<String> validate(T t, RuleGroup g);
    
}
