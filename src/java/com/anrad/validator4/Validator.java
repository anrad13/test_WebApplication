/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anrad.validator4;

import java.util.List;

/**
 *
 * @author Radoselskiy
 */
public interface Validator<T> {
    List<String> validate(T t, RuleGroup g);
    
}
