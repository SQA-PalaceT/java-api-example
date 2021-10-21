package mavenpackage.pages;
import java.io.IOException;

import mavenpackage.bases.Elements;
import mavenpackage.data.DataHomePalace;

public class PageQuotationForm extends Elements{
    //Manda a llamar la clase dataHomePalace
    DataHomePalace dataHomePalace = new DataHomePalace();
    PageCalendar pageCalendar = new PageCalendar();
    Integer scrollDownPage = 100;
   
    public void takeScreenshotHomePage() throws IOException{
        takeScreenshot("TestFlexibleRateUS","homePage");
    }
    //Cotización del primer formulario del home de palace
    public String reserveQuotation() throws Exception {
        if(waitUntilVisibleElements(dataHomePalace.getQuotationForm())){
            clickCssSelector(dataHomePalace.getCcBanner());
            clickCssSelector(dataHomePalace.getSelectResort());
            clickCssSelector(dataHomePalace.getOptionResort());
            pageCalendar.dataCalendar();
            pageCalendar.dynamicCalendar("Noviembre 2021", "13");
            //pageCalendar.calendar();
            clickCssSelector(dataHomePalace.getSelectRoom());
            scrollDownDynamic(driver, scrollDownPage);
            waitUntilVisibleElementT(dataHomePalace.getAddAdult());
            clickCssSelector(dataHomePalace.getAddAdult());
            takeScreenshot("TestFlexibleRateUS", "reserveQuotation");
            return getTextXPath(dataHomePalace.getElementFormContainer());
            //return getText(dataHomePalace.elementFormContainer);
        } else {
           return "The quotation form was not found...";
        }
    }
    //Salto a la siguiente página manteniendo la segunda pestaña abierta para obtener los objetos del DOM
    public void nextPage() throws Exception{
        //Almacena el ID de la ventana original
        String originalWindow = driver.getWindowHandle();
        //Comprueba que no existen otras ventanas abiertas previamente
        assert driver.getWindowHandles().size() == 1;
        clickCssSelector(dataHomePalace.getButtonReservation());
        //Recorre hasta encontrar el controlador de la nueva ventana
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        elementWaitT(dataHomePalace.getWaitPageRoom());
    }
    //Método para ingresar a la página admin sin afectar la pre-cotización 
    public void adminPage() throws InterruptedException, IOException{
        Thread.sleep(5000);
        if(waitUntilVisibleElementT(dataHomePalace.getWaitPageRoom())){
            driver.get(driver.getCurrentUrl().replace("rooms", "admin-bengine"));
            //elementWait(dataHomePalace.formAdmin);
        } else {
            System.out.println("The page room was not found...");
        }
    }
}