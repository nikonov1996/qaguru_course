package org.example.patterns.Strategy.qa;

public class LoginByAPI implements Login{
    @Override
    public void login(String login, String password) {
        System.out.println("Login by Api with login - " + login + " and password - " + password);
    }
}
