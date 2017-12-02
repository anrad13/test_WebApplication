package com.anrad.dbo;

import java.util.List;

public interface StoreService<T,ID>  {
    void put(T t);
    void put(List<T> lt);
    
    List<T> get();
    T get(ID id);
    
    void del();
    void del(ID id);
   
}
