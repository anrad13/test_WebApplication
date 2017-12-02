package com.anrad.validator;

public interface ValidatorRule<T> {
    
    void apply(T t) throws ValidationRuleException;
    
    
}
