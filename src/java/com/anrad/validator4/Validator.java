
package com.anrad.validator4;

import java.util.List;


public interface Validator<T> {
    List<String> validate(T t, RuleGroup g);
    
}
