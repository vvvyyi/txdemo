package com.tx.service.result;

public class LoginResult{
    String token;
    String uid;

    public LoginResult(String token, String uid) {
        this.token = token;
        this.uid = uid;
    }

    public String getToken() {
        return token;
    }

    public String getUid() {
        return uid;
    }
}