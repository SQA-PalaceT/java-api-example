package mavenpackage.bases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import mavenpackage.reusableComponents.NoSuchElementCustomException;

import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Elements extends BaseObjects{

    protected JavascriptExecutor js;
    private static final int TIMEOUT = 30;

    //Dentro de los métodos se llaman los métodos de selenium 
    //En caso de cambiar una versión de selenium sólo se modificarían estos métodos
    public WebElement findElement(By locator) throws Exception{
        try {
            return driver.findElement(locator);
        } catch (Exception e) {
            throw new Exception("The element '"+locator.getClass()+"' was not found.");
        }
    }
    /*  This method allows you to click an item
        The type of value you pass is a string which will allow you to get it from the property file
    */
    public WebElement elementClic(String locator) throws Exception{
        try {
            return driver.findElement(By.xpath(locator.toString()));
        } catch (Exception e) {
            throw new Exception("The element '"+locator.getClass()+"' was not found.");
        }
        
    }
    // Closes and quit the driver used to run the test
    public static void closeAndQuitDriver(){
        System.out.println("Close And Quit");
        driver.close();
        driver.quit();
    }
    // De vuelve la lista del elemento que se esta pasando
    public List<WebElement> findListOfElementsCssSelector(String locator) throws Exception{
        try {
            return driver.findElements(By.cssSelector(locator));
        } catch (Exception e) {
            throw new Exception("The element '"+locator.getClass()+"' was not found.");
        } 
    }
    //
    public void clickOneElementList(List<WebElement> elementList,int id){
        elementList.get(id).click();
    }

    public String getTextElementList(List<WebElement> elementList,int id) throws Exception{
        try {
            return elementList.get(id).getText();}
         catch (Exception e) {
            throw new Exception("The element '"+elementList+"' was not found.");
        }
    }


    // Devuelve el elemento del texto del parámetro que se esta pasando 
    public String getText(WebElement element) throws Exception{
        try {
            return element.getText();
        } catch (Exception e) {
            throw new Exception("The element '"+element+"' was not found.");
        }
        
    }
    /*  This method allows to get the text from a string
        The type of value you pass is a string which will allow you to get it from the property file
    */
    public String getTextCssSelector(String locator) throws Exception{
        try {
            driver.findElement(By.cssSelector(locator)).isDisplayed();
            return driver.findElement(By.cssSelector(locator)).getText();
        } catch (Exception e) {
            throw new Exception("The element '"+locator+"' was not found.");
        }
        
    }
    //De vuelve el texto del elemento que se esta buscando a traves de ese localizador
    //--------------Delete-----------------------------------
    public String getText(By locator){
        return driver.findElement(locator).getText();
    }
    //--------------Stay-----------------------
    public String getTextXPath(String locator){
        return driver.findElement(By.xpath(locator)).getText();
    }
    //-------------------------------------------------------
    //Método para enviar los caracteres (type=teclear)
    //Se le pasara el texto y un locator para ubicar dónde se quiere escribir ese texto
    //-----------------Delete-------------------------
    public void enterText(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }
    //------------------Stay-------------------------------
    public void enterTextCssSelector(String inputText, String locator){
        driver.findElement(By.cssSelector(locator)).sendKeys(inputText);
    }
    public void enterTextXPath(String inputText, String locator){
        driver.findElement(By.xpath(locator)).sendKeys(inputText);
    }
    //Método click
    public void click(By locator) throws Exception{
        try {
            driver.findElement(locator).isDisplayed();
            driver.findElement(locator).click();
        } catch (Exception e) {
            throw new Exception("The element '"+locator+"' was not found.");
        }
    }
    public void clickXpath(String locator) throws Exception{
        try{
            driver.findElement(By.xpath(locator)).isDisplayed();
            driver.findElement(By.xpath(locator)).click();
        }catch(Exception ex){
            throw new Exception("The element By.xpath:'"+locator+"' not found.");
        }
    }

    public void clickCssSelector(String locator) throws Exception{
        try{
            driver.findElement(By.cssSelector(locator)).isDisplayed();
            driver.findElement(By.cssSelector(locator)).click();
        }catch(Exception ex){
            throw new Exception("The element By.cssSelector:'"+locator+"' not found.");
        }
    }

    public void clickClassName(String locator) throws Exception{
        try{
            driver.findElement(By.className(locator)).isDisplayed();
            driver.findElement(By.className(locator)).click();
        }catch(Exception ex){
            throw new Exception("The element By.className:'"+locator+"' not found.");
        }
    }

    public void clickId(String locator) throws Exception{
        try{
            driver.findElement(By.id(locator)).isDisplayed();
            driver.findElement(By.id(locator)).click();
        }catch(Exception ex){
            throw new Exception("The element By.className:'"+locator+"' not found.");
        }
    }

    //Método para saber si el elemento esta listo para ser utilizado
    public Boolean isDisplayed(By locator){
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
    //Método para ir a una url 
    public static void goToUrlAndWindowMaximize(String url){
        driver.get(url);
        driver.manage().window().maximize();
    }
    //Método para limpiar un campo check.this
    public void clearTheField(By locator){
        driver.findElement(locator).clear();
    }
    //Método para hacer scroll down a la página
    public void scrollDown(WebDriver driver){
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }
    //Método para hacer scroll dinamico
    public void scrollDownDynamic(WebDriver driver, Integer scrolldown){
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+scrolldown+")");
    }

    public WebElement waitUntilVisibleE(String locator) throws NoSuchElementCustomException{
        try{
            WebDriverWait ewait = new WebDriverWait(driver,Duration.ofSeconds(TIMEOUT));
            return ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
        } catch(Exception e){
            throw new NoSuchElementCustomException("No se encontró Elemento \""+locator+"\"",e);
        }    
    }

    
    public WebElement waitUntilVisibleEString(String locator) throws NoSuchElementCustomException{
        try{
            WebDriverWait ewait = new WebDriverWait(driver,Duration.ofSeconds(TIMEOUT));
            return ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
        } catch(Exception e){
            throw new NoSuchElementCustomException("No se encontró Elemento \""+locator+"\"",e);
        }    
    }

    //--------------------Delete------------------------------------------------------------------------
    public boolean waitUntilVisibleElement(By locator){
        WebDriverWait ewait = new WebDriverWait(driver,Duration.ofSeconds(TIMEOUT));
        try{
            ewait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (org.openqa.selenium.NoSuchElementException ex){
            return false;
        }
    }
    //--------------------Stay----------------------------------------------------------------
    public boolean waitUntilVisibleElementT(String locator){
        WebDriverWait ewait = new WebDriverWait(driver,Duration.ofSeconds(TIMEOUT));
        try{
            ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
            return true;
        } catch (org.openqa.selenium.NoSuchElementException ex){
            return false;
        }
    }
    //---------------------------------------------------------------------------------------------------------
    public WebElement waitUntilVisibleElms(By locator) throws NoSuchElementCustomException{
        try{
            WebDriverWait ewait = new WebDriverWait(driver,Duration.ofSeconds(TIMEOUT));
            return (WebElement) ewait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        } catch(Exception e){
            throw new NoSuchElementCustomException("No se encontraron los Elementos del localizador: \""+locator+"\"",e);
        }    
    }
    /* This method is used to wait for the elements of the page to be displayed 
        Selectors are obtained by using a String to use the property files of each page
        for this method cssSelector is used
    */
    public boolean waitUntilVisibleElements(String locator){
        WebDriverWait ewait = new WebDriverWait(driver,Duration.ofSeconds(30));
        try{
            ewait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(locator)));
            return true;
        } catch (org.openqa.selenium.NoSuchElementException ex){
            return false;
        }
    }
    //---------------------------------------------------------------------------------------------------
    public boolean waitUntilToBeClickable(By locator){
        WebDriverWait ewait = new WebDriverWait(driver,Duration.ofSeconds(30));
        try{
            ewait.until(ExpectedConditions.elementToBeClickable(locator));
            return true;
        } catch (org.openqa.selenium.NoSuchElementException ex){
            return false;
        }
    }

    public boolean waitUntilInvisibilityOf(WebElement locator) throws NoSuchElementCustomException{
        try {
            WebDriverWait ewait = new WebDriverWait(driver,Duration.ofSeconds(30));
            return ewait.until(ExpectedConditions.invisibilityOf(locator));
        } catch (Exception e) {
            throw new NoSuchElementCustomException("Elemento \""+locator+"\" se encuentra visibñe..",e);
        }
        
    }
    /**
     * La función devuelve su elemento web encontrado
     * elemntWait es una implementación de la interfaz de espera que puede tener su tiempo de espera 
     * y el intervalo de sondeo (polling interval) configurados.
     * Cada instancia de FluentWait define la cantidad máxima de tiempo para esperar una condición, 
     * así como la frecuencia con la que se verifica. 
     * Ignorar tipos específicos de excepciones mientras espera, 
     * como NoSuchElementExceptions al buscar un elemento en la página.
    */
    public WebElement elementWaitT(final String locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(15))
            .pollingEvery(Duration.ofMillis(500))
            .ignoring(NoSuchElementException.class);
        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.cssSelector(locator));
            }
        });
        return  foo;
    } 
    //----------------------------------------------------------------------------------
    
    /**
     * Método para tomar screenshot de la ejecución de los test
     * @return 
     * @throws IOException
     */
    public String takeScreenshot(String folderName, String fileName) throws IOException{
        //Toma una captura de pantalla y la almacena como un formato de archivo
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //Copia la captura de pantalla a la ubicación deseada utilizando el método copifile
        FileUtils.copyFile(file, new File("./src/test/java/mavenpackage/reports/screenshots/"+folderName+"/"+fileName+".jpg"));
        return folderName + fileName;
    }

    public String getScreenshot(WebDriver driver) throws IOException{
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("./src/test/java/mavenpackage/reports/screenshots/")+System.currentTimeMillis()+".png";
        File destination = new File(path);
        try{
            FileUtils.copyFile(src, destination);
        }catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Capture Failed " + e.getMessage());
        }
        return path;
    }
    /* Method for using a timeout */
    public void sleep(long milisec){
        try {
            Thread.sleep(milisec);
        } catch (Exception e) {
        }
        
    }
    
}