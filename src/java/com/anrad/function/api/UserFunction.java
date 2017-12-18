package com.anrad.function.api;

public interface UserFunction<T,R> {
    
    R apply(T t);
    
}
