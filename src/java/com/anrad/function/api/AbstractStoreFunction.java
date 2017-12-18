package com.anrad.function.api;

import com.anrad.dbo.StoreService;
import java.util.List;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

public abstract class AbstractStoreFunction<DTO,ID,U,R>
        implements UserFunction<U,R>
{
    @Inject @Any
    private Instance<StoreService<DTO, ID>> store;
    
    protected final StoreService<DTO, ID> getStore() {
        return store.get();
    } 
    
      
}