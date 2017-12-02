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
        List<T> newStorage = new ArrayList<>();
        this.storageList.stream()
                .filter((t) -> (! t.getId().equals(id)))
                .forEachOrdered((t) -> {
                    newStorage.add(t);
                    }
                );
        this.del();
        this.put(newStorage);
    }
}
