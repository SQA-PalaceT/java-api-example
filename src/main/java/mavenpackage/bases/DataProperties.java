package mavenpackage.bases;

import java.io.IOException;

import mavenpackage.reusableComponents.PropertiesOperations;


public class DataProperties {

    private String propertyFile;
    private PropertiesOperations propertyOp = new PropertiesOperations();

    protected DataProperties(String propertyFile){
        this.propertyFile = propertyFile;
    }

    protected String getProperty(String propertyName) throws IOException {
        return propertyOp.getPropertiesValueByKey(propertyName, propertyFile);
    }
    
}
