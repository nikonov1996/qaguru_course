package org.example.patterns.Strategy.qa;

public class LoginPage {

    public void login(Login login,User user){
        login.login(user.getLogin(), user.getPassword());
    }
}

class User{
    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    String login;
    String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
