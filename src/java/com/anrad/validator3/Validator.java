/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anrad.validator3;


public interface Validator<T extends Object> {
    
    void validate(T t);
    
}
