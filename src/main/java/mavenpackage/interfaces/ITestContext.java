package mavenpackage.interfaces;

import java.io.IOException;

public interface ITestContext {

    public String getReportName() throws IOException;
    public String getTestCaseName() throws IOException ;
    public String getBrowser() throws IOException ;
    public String getUrl() throws IOException ;    
}
