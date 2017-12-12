/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anrad;

import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named(value = "statusBarController")
@RequestScoped

public class StatusBarController {
    
    private String timestamp = new Date().toString();
    private String userName = "unknown";
    private String systemStatus = "unknown";
    private String sessionStatus = "unknown";
    
    
    public StatusBarController() {}
    
    
    public void get() {
        timestamp = new Date().toString();
        userName = "unknown1";
        systemStatus = "unknown1";
        sessionStatus = "unknown1";
        
        //FacesContext fc = FacesContext.getCurrentInstance();
        //HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        //sessionStatus = session.getId();
        
    }
    
    public String getTimestamp() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        timestamp = new Date(session.getCreationTime()).toString();
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUserName() {
        FacesContext fc = FacesContext.getCurrentInstance();
        userName = fc.getExternalContext().getRemoteUser();
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSystemStatus() {
        return systemStatus;
    }

    public void setSystemStatus(String systemStatus) {
        this.systemStatus = systemStatus;
    }

    public String getSessionStatus() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        sessionStatus = session.getId();
        return sessionStatus;
    }

    public void setSessionStatus(String sessionStatus) {
        this.sessionStatus = sessionStatus;
    }
    
    
    
    
}
