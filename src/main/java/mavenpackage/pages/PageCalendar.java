package mavenpackage.pages;

import java.io.IOException;

import mavenpackage.bases.Elements;
import mavenpackage.data.DataCalendar;

public class PageCalendar extends Elements {
    DataCalendar dataCalendar = new DataCalendar();
    Integer minimumMonth = 2;

    public String labelFlyPlusHotel(int posición) throws IOException, Exception{
        sleep(5);
        return getTextElementList(findListOfElementsCssSelector(dataCalendar.getLabelFlyPlusHotel()),posición);
    }

    public void calendar() throws Exception{
        //The calendar is clicked by getting the xpath of the dom object
        clickXpath(dataCalendar.getCalendar());
        //In this sentence, the selection will be made to 3 months from the current date
        try {
            /*  As a business rule, any reservation must be from the current date to 3 months
                in order to be able to cancel it in case of making a paid
            */
            for(int i=0; i < minimumMonth; i++){
                clickXpath(dataCalendar.getNextMonthBrowser(testBrowser));
            }
        } catch (Exception e) {
            System.out.println("Fail");
        }
        clickXpath(dataCalendar.getDayCheckInMonth(testBrowser));
        clickXpath(dataCalendar.getCalendarCheckOut());
        clickXpath(dataCalendar.getDayCheckOutMonth(testBrowser));
    }

    public void dataCalendar() throws IOException, Exception{
        clickXpath(dataCalendar.getCalendar());
    }

    public void dynamicCalendar(String month, String day) throws Exception{
        String textMonth = getTextCssSelector(dataCalendar.getMonth());
        if(textMonth.equals(month)){
            String textD = dataCalendar.getDayDynamicMonth() + "[contains(text(), '" + day + "')]";
            clickXpath(textD);
        }else{
            clickXpath(dataCalendar.getNextMonthBrowser(testBrowser));
            dynamicCalendar(month, day);
        }
    }
}
