package org.example.patterns.Factory;

public class DriverFactory {

    public WebDriver getDriver(DriverType type){
        WebDriver webDriver = null;
        switch (type){
            case FIREFOX:
                webDriver = new FirefoxDriver();
                break;
            case CHROME:
                webDriver = new ChromeDriver();
                break;
            default:
                throw new IllegalArgumentException("Incorrect WebDriver type - " + type);
        }
        return webDriver;
    }
}
