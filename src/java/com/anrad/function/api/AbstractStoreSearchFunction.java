/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anrad.function.api;

import java.util.ArrayList;
import java.util.List;

public class AbstractStoreSearchFunction<DTO,ID>
        extends AbstractStoreFunction<DTO,ID,String,List<DTO>>
        implements UserFunction<String,List<DTO>>
{
    @Override
    public List<DTO> apply(String s) {
        //List<R> r = null;
        List<DTO> l = this.getStore().get();
        
        return l;
    }
}
