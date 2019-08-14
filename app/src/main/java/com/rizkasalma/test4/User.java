package com.rizkasalma.test4;

public class User {

    private String name, email, no_hp;

    public User( String name, String email, String no_hp) {

        this.name = name;
        this.email = email;
        this.no_hp = no_hp;
    }


    public String getname() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getNo_hp() {
        return no_hp;
    }
}
