package mavenpackage.bases.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import mavenpackage.interfaces.IDriver;

public class ChromeDriver implements IDriver{

    public WebDriver getDriver() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        return (WebDriver) new org.openqa.selenium.chrome.ChromeDriver();
    }
    
}
