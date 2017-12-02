/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anrad.validator2;

import com.anrad.dbo.Storeable;

/**
 *
 * @author Radoselskiy
 */
public interface Rule {
    void apply(Storeable dto) throws RuleException;
    
    public Class<? extends Storeable> getDtoClass() ;

    public RuleGroup getGroup() ;

}
