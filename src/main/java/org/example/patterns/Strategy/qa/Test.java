package org.example.patterns.Strategy.qa;

public class Test {

    public static void main(String[] args) {
        LoginPage loginPage = new LoginPage();
        User apiUser = new User("apilogin","apipass");
        User uiUser = new User("uilogin","uipass");
        loginPage.login(new LoginByAPI(),apiUser);
        loginPage.login(new LoginByUI(),uiUser);
    }
}
