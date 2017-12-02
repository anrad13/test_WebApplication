package com.anrad.validator;

import java.lang.reflect.ParameterizedType;


public abstract class AbstractSimpleInterface<T> implements SimpleInterface<T> {
    
    public static Class getGenericParameterClass(Class actualClass, int parameterIndex) {
        return (Class) ((ParameterizedType) actualClass.getGenericSuperclass()).getActualTypeArguments()[parameterIndex];
    }
        
}
