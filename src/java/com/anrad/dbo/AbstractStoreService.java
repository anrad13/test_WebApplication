package com.anrad.dbo;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStoreService<T extends Storeable,ID> implements StoreService<T,ID> {
    private final List<T> storageList;
    
    
    public AbstractStoreService() {
        this.storageList = new ArrayList<>();
    }
    
    @Override
    synchronized public void put(T t) {
        if (t.getId() != null)  {
            //update existing object if it present 
            for (int i = 0; i < storageList.size(); i++) {
                if (t.getId().equals(storageList.get(i).getId())) {
                    storageList.set(i, t);
                    return;
                }
            }
        } 
        // add new object
        storageList.add(t);
    }
    
    @Override
    synchronized public void put(List<T> lt) {
        lt.stream().forEachOrdered(
                (T t)->{this.storageList.add(t);}
                );
    }

    @Override
    synchronized public List<T> get() {
        return storageList;
    }
    
    @Override
    synchronized public T get(ID id) {
        for( T t : this.get() ) {
            if (t.getId().equals(id)) return t;
        }
        return null;
    }
    
    @Override
    synchronized public void del() {
        storageList.clear();
    }
    
    @Override
    synchronized public void del(ID id) {
        for (int i = 0; i < storageList.size(); i++) {
                if (id.equals(storageList.get(i).getId())) {
                    storageList.remove(i);
                    return;
                }
            }
        
    }
}
