package mavenpackage.data;

import java.io.IOException;

import mavenpackage.bases.DataProperties;

public class DataCalendar extends DataProperties {

    public DataCalendar() {
        super("DataCalendar");
    }
    public String getCalendar() throws IOException {
        return getProperty("calendar");
    }
    public String getMonth() throws IOException {
        return getProperty("month");
    }
    public String getNextMonth() throws IOException {
        return getProperty("nextMonth");
    }
    public String getDayCheckIn() throws IOException {
        return getProperty("dayCheckIn");
    }
    public String getCalendarCheckOut() throws IOException {
        return getProperty("calendarCheckOut");
    }
    public String getDayCheckOut() throws IOException {
        return getProperty("dayCheckOut");
    }
    public String getDayDynamicMonth() throws IOException {
        return getProperty("dayDynamicMonth");
    }
    public String getNextMonthBrowser(String browser) throws IOException{
        return getProperty(browser + ".nextMonth");
    }
    public String getNameMonth(String browser) throws IOException{
        return getProperty(browser + ".nameMonth");
    }
    public String getDayCheckInMonth(String browser) throws IOException{
        return getProperty(browser + ".dayCheckIn");
    }
    public String getDayCheckOutMonth(String browser) throws IOException{
        return getProperty(browser + ".dayCheckOut");
    }

    public String getLabelFlyPlusHotel() throws IOException{
        return getProperty("labelFlyPlusHotel");
    }
}