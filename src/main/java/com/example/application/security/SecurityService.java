/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.application.security;

import com.vaadin.flow.spring.security.AuthenticationContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 *
 * @author george
 */

@Component
public class SecurityService {
    private final AuthenticationContext authenticationContext;
    
    public SecurityService(AuthenticationContext authenticationContext) {
        this.authenticationContext = authenticationContext;
    }
    
    public UserDetails getAuthenticatedUser(){
        return this.authenticationContext
                .getAuthenticatedUser(UserDetails.class)
                .get();
    }
    
    public void logout() {
        authenticationContext.logout();
    }
}
