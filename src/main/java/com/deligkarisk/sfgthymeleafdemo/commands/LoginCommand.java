package com.deligkarisk.sfgthymeleafdemo.commands;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginCommand {

    @NotEmpty
    @Size(min=2, max=12)
    private String userName;

    // Better to use NotEmpty, as an empty string will pass the NotNull constraint, but not the NotEmpty constraint.
    @NotEmpty
    @Size(min=5, max=10)
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
