/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anrad.validator4;


public interface Rule<T> {
    void apply(T t) throws Exception;
    RuleGroup getGroup();
}
