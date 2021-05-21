package com.banking.services.api.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Credentials {
    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
