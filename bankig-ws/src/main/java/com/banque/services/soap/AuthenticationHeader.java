package com.banque.services.soap;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * Created by Aaron on 05/19/2021.
 */
@XmlRootElement(name = "AuthHeader", namespace = "http://soap.services.banque.com")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"username", "password"})
public class AuthenticationHeader implements Serializable {
    @XmlElement(required = true)
    private String username;
    @XmlElement(required = true)
    private String password;

    public AuthenticationHeader() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
