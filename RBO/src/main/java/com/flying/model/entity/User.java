package com.flying.model.entity;

import lombok.Data;

@Data
public class User {
    private String userName;
    private String password;

    public String toString(){
        return userName + "; " + password;
    }
}
