/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anrad.function.api;


public class AbstractStoreGetFunction <DTO,ID>
        extends AbstractStoreFunction<DTO,ID,ID,DTO>
        implements UserFunction<ID,DTO>
{
    @Override
    public DTO apply(ID id) {
        //List<R> r = null;
        DTO dto = this.getStore().get(id);
        
        return dto;
    }
}
