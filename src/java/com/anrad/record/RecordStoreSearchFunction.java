package com.anrad.record;

import com.anrad.function.api.AbstractStoreSearchFunction;
import com.anrad.function.api.UseCase;
import com.anrad.function.api.UserFunction;
import java.util.List;
import javax.inject.Named;

//@Named("RecordStoreSearchFunction")
@UseCase("RecordStoreSearchFunction")

public class RecordStoreSearchFunction 
        extends AbstractStoreSearchFunction<Record,String>
        implements UserFunction<String,List<Record>>

{
    
}
