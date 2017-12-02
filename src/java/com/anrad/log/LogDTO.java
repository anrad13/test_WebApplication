/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anrad.log;

/**
 *
 * @author Radoselskiy
 */
public class LogDTO {
    private String id;
    private String t;
    private String name;
    private String msg;
    
    public LogDTO() {}
    
    public LogDTO(LogRecord r) {
        id = r.getId();
        t= r.getT();
        name = r.getName();
        msg = r.getMsg();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    
}
