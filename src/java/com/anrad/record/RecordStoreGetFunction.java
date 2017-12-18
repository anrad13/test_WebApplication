package com.anrad.record;

import com.anrad.function.api.AbstractStoreGetFunction;
import com.anrad.function.api.UserFunction;
import javax.inject.Named;

@Named("RecordStoreGetFunction")
public class RecordStoreGetFunction 
    extends AbstractStoreGetFunction<Record,String>
    implements UserFunction<String,Record>
{
}
