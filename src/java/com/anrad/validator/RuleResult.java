/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anrad.validator;

/**
 *
 * @author Radoselskiy
 */
public class RuleResult {
    private final RuleError error;
    private final String message;
    private final boolean isValid;

    public RuleResult(RuleError error, String message, boolean isValid) {
        this.error = error;
        this.message = message;
        this.isValid = isValid;
    }

    public RuleError getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public boolean isIsValid() {
        return isValid;
    }
    
    public String toString() {
        return 
                "err = " + error + ", "
                + "msg = " + message + ", "
                + "isValid = " + isValid
                ;
    }
    
}
