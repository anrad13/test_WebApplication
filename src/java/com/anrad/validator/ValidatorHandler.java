package com.anrad.validator;

import java.util.List;

public interface ValidatorHandler<T> {
    
   List<String> validate(T t,ValidatorGroup g);
   
}
