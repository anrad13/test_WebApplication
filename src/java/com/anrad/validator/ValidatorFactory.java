package com.anrad.validator;

public interface ValidatorFactory<T> {
    ValidatorHandler<T> getValidator();
}
