package com.mathseiw.quizz.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;

public class User {
    
    @NotNull
    @Value("${user.default.username:Default}")
    @Size(min=2, max=30) 
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername( String username ) {
        this.username = username;
    }
}