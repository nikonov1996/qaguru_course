package org.example.patterns.Strategy.qa;

public class LoginByUI implements Login{
    @Override
    public void login(String login,String password) {
        System.out.println("Login by ui  with login - " + login + " and password - " + password);
    }
}
