
package mavenpackage.bases;

import java.io.IOException;

public class TestBase extends DataProperties {

    public TestBase() {
        super("happyPathTC");
    }

    public String geturlLoginFlexibleRate() throws IOException{
        return getProperty("urlLoginFlexibleRate");
    }

    public String getTagHotel() throws IOException{
        return getProperty("tagHotel");
    }

    public String getOutputMarket() throws IOException{
        return getProperty("outputMarket");
    }

    public String getTitleQuote() throws IOException{
        return getProperty("titleQuote");
    }

    public String getTagCampos() throws IOException{
        return getProperty("tagCampos");
    }

    public String getTagInformacion() throws IOException{
        return getProperty("tagInformacion");
    }
    
    public String getCheckIn() throws IOException{
        return getProperty("CheckIn");
    }

    public String getCheckOut() throws IOException{
        return getProperty("CheckOut");
    }

    public String getFechaDinamica() throws IOException{
        return getProperty("FechaDinamica");
    }

    public String getMarket() throws IOException{
        return getProperty("market");
    } 

    public String getFirstName() throws IOException{
        return getProperty("firstName");
    }
    
    public String getLastName() throws IOException{
        return getProperty("lastName");
    }

    public String getBirthday() throws IOException{
        return getProperty("birthday");
    }
    
    public String getPhoneNumber() throws IOException{
        return getProperty("phoneNumber");
    }

    public String getEmail() throws IOException{
        return getProperty("email");
    }

    public String getPostalCode() throws IOException{
        return getProperty("postalCode");
    }

    public String getCity() throws IOException{
        return getProperty("city");
    }

    public String getSpecialRequirements() throws IOException{
        return getProperty("specialRequirements");
    }

    public String getUser() throws IOException {
        return getProperty("user");
    }

    public String getPassword() throws IOException {
        return getProperty("password");
    }

    public String getCardN() throws IOException{
        return getProperty("cardN");
    }

    public String getCardH() throws IOException{
        return getProperty("cardH");
    }

    public String getCvvC() throws IOException{
        return getProperty("cvvC");
    }
}