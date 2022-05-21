package com.syliva.mymall.config.security;


import org.apache.shiro.authc.AuthenticationToken;


public class AuthToken implements AuthenticationToken {
    private String token;

    public AuthToken(String token){
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
