package mavenpackage.bases.browsers;

import org.openqa.selenium.WebDriver;

import mavenpackage.interfaces.IDriver;

public class FirefoxDriver implements IDriver{

    public WebDriver getDriver() {
        return (WebDriver) new org.openqa.selenium.firefox.FirefoxDriver();
    }
    
}
