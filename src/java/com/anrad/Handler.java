/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anrad;

import javax.ejb.Stateless;


import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


@Named(value = "handler")
@RequestScoped


public class Handler {
    private String name = "Handler";
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

}
