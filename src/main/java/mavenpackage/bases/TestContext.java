package mavenpackage.bases;

import java.io.IOException;

import mavenpackage.interfaces.ITestContext;

public class TestContext extends DataProperties implements ITestContext{

    public TestContext() {
        super("happyPathTC");
    }

    @Override
    public String getReportName() throws IOException {
        return getProperty("reportName");
    }


    @Override
    public String getTestCaseName() throws IOException {
        return getProperty("testCaseName");
    }


    @Override
    public String getBrowser() throws IOException {
        return getProperty("browser");
    }


    @Override
    public String getUrl() throws IOException {
        return getProperty("url");
    }    
}
