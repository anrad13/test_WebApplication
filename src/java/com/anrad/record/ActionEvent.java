package com.anrad.record;

public class ActionEvent<T> {
    final T t;
    
    public ActionEvent (T t) {
        this.t = t;
    }
    
    public T get() { return t; }
    
}
