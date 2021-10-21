package mavenpackage.reports;

import java.text.SimpleDateFormat; 
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import mavenpackage.bases.BaseObjects;
import mavenpackage.bases.TestContext;
import mavenpackage.interfaces.ITestContext;

public class ExtentSetup extends BaseObjects{
   
    public static ExtentReports setUpExtentReport() throws Exception{

        ITestContext context = new TestContext();
        testBrowser = context.getBrowser();
        testUrl = context.getUrl();
        String reportName = context.getReportName();
        
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
        Date date = new Date();
        String actualDate = format.format(date);
        String reportpath = "./src/test/java/mavenpackage/reports/reportsGenerated/" + reportName +"_"+ actualDate + ".html";
        
        
        ExtentSparkReporter  report = new ExtentSparkReporter (reportpath); // generate the report
        
        extentreport = new ExtentReports();
        extentreport.attachReporter(report); // attach the reporter which we created

        report.config().setDocumentTitle("Quality Assurance Report | Palace Resorts®");
        report.config().setReportName(reportName);
        extentreport.setSystemInfo("Ejecutado en ambiente: ", testUrl); //De dónde voy a leer la URL del propertyFile o de un Excell o de una clase.
        extentreport.setSystemInfo("Ejecutado en Navegador:", testBrowser );
        extentreport.setSystemInfo("Ejecutado en S.O.:", System.getProperty("os.name"));
        extentreport.setSystemInfo("Ejecutado por usuario:", System.getProperty("user.name"));
        
        return extentreport;
    }
    
}
