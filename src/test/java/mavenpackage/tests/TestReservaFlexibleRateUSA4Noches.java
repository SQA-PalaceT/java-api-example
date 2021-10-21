package mavenpackage.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;

import mavenpackage.bases.TestBase;
import mavenpackage.bases.BaseObjects;
import mavenpackage.bases.Elements;
import mavenpackage.bases.TestDriver;
import mavenpackage.pages.PageQuotationForm;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Listeners(mavenpackage.reports.ListenersImplementation.class)
public class TestReservaFlexibleRateUSA4Noches extends BaseObjects{

    PageQuotationForm quotePage;
    TestBase testExpectedResult;
    TestDriver testdriver;

    // Proceso que se realiza antes de ejecutar el tTCest
    @BeforeTest
    public void setUp() throws Exception {
        testdriver = new TestDriver();
        testdriver.launchBrowser(testBrowser);//Se pasa el Propertie del TestCase dónde toma el navegador para la prueba.
        testdriver.navigateURL(testUrl);
    }
    // Proceso para ejecutar el test
    @Test
    //@DisplayName("Test - Flexible rate USA reservation")
    public void testReservaE2EFlexibleRateUSA() throws Exception {
        quotePage = new PageQuotationForm();
        testExpectedResult = new TestBase();
        // Cotización
        quotePage.takeScreenshotHomePage();
        Assert.assertTrue(quotePage.reserveQuotation().contains(testExpectedResult.getTagHotel()));
        quotePage.nextPage();
        // Cambio de url y LogIn para cambio de Mercado
        quotePage.adminPage();
    }

    // Proceso que se realiza al final de ejecutar el test
    @AfterTest
    public void tearDown(){ 
        //Close browser
        Elements.closeAndQuitDriver();
        System.out.println("Test Closed");
    }
}