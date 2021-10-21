package mavenpackage.bases;

import mavenpackage.interfaces.IDriver;

public class TestDriver extends DataProperties{
    
    public TestDriver() {
        super("driver");
    }

    private String browsers;
    private String pathBrowser;
    private String driverBrowser;
                                    
    public void  launchBrowser(String browser) throws Exception{
        
        String className;
        browsers = getProperty("browsers");

        if (browsers.contains(browser)){
            //Contrucción del path y Driver
            pathBrowser = getProperty(browser +".path");
            driverBrowser = getProperty(browser+".driver");
            System.setProperty(driverBrowser,pathBrowser);
            className = getProperty(browser+".class");
            IDriver driverManager = getDriverManager(browser,className);
            BaseObjects.driver = driverManager.getDriver();
        }
        else { 
            throw new Exception("Browser \""+browser+"\" is not supported."); 
        }       
    }

    public void navigateURL(String url) throws Exception{
        Elements.goToUrlAndWindowMaximize(url);
    }

    private static IDriver getDriverManager(String browser,String className) throws Exception {
        Class<?> c = Class.forName(className);
        Object o = c.getDeclaredConstructor().newInstance();
        return (IDriver) o;
    }
}
