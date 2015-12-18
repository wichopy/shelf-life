package me.jcomo.foodie.core;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.security.Principal;

public class User implements Principal {
    private final String username;

    @JsonIgnore
    private final String passwordHash;

    @JsonIgnore
    private String sessionId = "";

    public User(String username, String password) {
        this.username = username;
        this.passwordHash = hashPassword(password);
    }

    @Override
    @JsonIgnore
    public String getName() {
        return getUsername();
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public boolean passwordMatches(String password) {
        return hashPassword(password).equals(getPasswordHash());
    }

    public static String hashPassword(String password) {
        return password;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}

