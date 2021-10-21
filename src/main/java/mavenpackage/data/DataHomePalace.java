package mavenpackage.data;
import java.io.IOException;

import mavenpackage.bases.DataProperties;

public class DataHomePalace extends DataProperties{
    
    public DataHomePalace() {
        super("DataHomePalace");
    }
    //Declaración de variables para obtener la posición de los objetos del front
    public String getQuotationForm() throws IOException {
        return getProperty("quotationForm");
    }
    public String getElementFormContainer() throws IOException {
        return getProperty("elementFormContainer");
    }
    public String getContainerToolBar() throws IOException {
        return getProperty("containerToolBar");
    }
    public String getCcBanner() throws IOException {
        return getProperty("ccBanner");
    }
    public String getSelectResort() throws IOException {
        return getProperty("selectResort");
    }
    public String getOptionResort() throws IOException {
        return getProperty("optionResort");
    }
    public String getSelectRoom() throws IOException {
        return getProperty("selectRoom");
    }
    public String getAddAdult() throws IOException {
        return getProperty("addAdult");
    }
    public String getButtonReservation() throws IOException {
        return getProperty("buttonReservation");
    }
    //Declaración de variables para el cambio de url
    public String getFormAdmin() throws IOException {
        return getProperty("formAdmin");
    }
    public String getWaitPageRoom() throws IOException {
        return getProperty("waitPageRoom");
    }
}
