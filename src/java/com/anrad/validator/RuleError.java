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
public enum RuleError {
    
    RECORD_ERR_001("RECORD_ERR_001","Validation error message", RuleGroup.DEFAULT, RuleType.ERROR),
    RECORD_ERR_002("RECORD_ERR_002","Validation error message", RuleGroup.DEFAULT, RuleType.ERROR),
    PERSON_ERR_001("PERSON_ERR_001","Validation error message", RuleGroup.DEFAULT, RuleType.ERROR);
    
    private final String errId;
    private final String errMessageId;
    private final RuleGroup errGroup;
    private final RuleType errType;

    private RuleError(String id, String msgId, RuleGroup g, RuleType t) {
        errId = id;
        errMessageId = msgId;
        errGroup = g;
        errType = t;
    }

    public String getErrId() {
        return errId;
    }

    public String getErrMessageId() {
        return errMessageId;
    }

    public RuleGroup getErrGroup() {
        return errGroup;
    }

    public RuleType getErrType() {
        return errType;
    }
    
    @Override
    public String toString() {
        return 
                "id = " + errId +
                ", msg = " + errMessageId +
                ", group = " + errGroup +
                ", type = " + errType;
    }

}
