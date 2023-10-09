package org.example.patterns.Factory;

public class Test {
    public static void main(String[] args) {
        DriverFactory driverFactory = new DriverFactory();
        WebDriver FirefoxDriver = driverFactory.getDriver(DriverType.FIREFOX);
        WebDriver ChromeDriver = driverFactory.getDriver(DriverType.CHROME);
        FirefoxDriver.run();
        ChromeDriver.run();
    }
}
