package com.deligkarisk.sfgthymeleafdemo.commands;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginCommand {

    @NotEmpty
    private String username;

    // Better to use NotEmpty, as an empty string will pass the NotNull constraint, but not the NotEmpty constraint.
    @NotEmpty
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
