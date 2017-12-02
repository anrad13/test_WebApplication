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
class RuleException extends Exception {
    /**
     * Creates a new instance of <code>RuleException</code> without detail
     * message.
     */
    public RuleException() {
    }

    /**
     * Constructs an instance of <code>RuleException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public RuleException(String msg) {
        super(msg);
    }
}
