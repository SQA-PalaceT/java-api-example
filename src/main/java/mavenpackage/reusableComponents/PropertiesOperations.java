package mavenpackage.reusableComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import mavenpackage.bases.BaseObjects;

public class PropertiesOperations extends BaseObjects {

    public String getPropertiesValueByKey(String simpleKey, String typeProperty) throws IOException {
        
        String compoundKey = testBrowser+"."+simpleKey;
        Object valueObject= null;

        Properties propertiesFile = loadPropertyFile(typeProperty);

        valueObject = getPropertyObject(propertiesFile, simpleKey);
        if( valueObject != null){
            return convertPropertyObjectToString(valueObject,simpleKey);
        } else if( (valueObject = getPropertyObject(propertiesFile, compoundKey)) != null){ 
            return convertPropertyObjectToString(valueObject,compoundKey);
        }else{
            throw new IOException("\nThe Key \"" + simpleKey + "\" or \"" + compoundKey + "\" doesn't exist in the property File \"" + typeProperty
                + ".properties" + "\"");
        }
    }


    private Properties loadPropertyFile(String typeProperty) throws IOException{
        Properties propertiesFile;
        String propertiesFilePath;

        propertiesFilePath = "./src/main/java/mavenpackage/resources/properties/" + typeProperty + ".properties";
        propertiesFile = new Properties();

        try {
            FileInputStream fis = new FileInputStream(propertiesFilePath);
            propertiesFile.load(fis);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("\nThe property File \"" + typeProperty + ".properties"
                    + "\" doesn't exist in the path \"" + propertiesFilePath + "\"");
        }
       return propertiesFile;
    }


    private Object getPropertyObject(Properties propertiesFile, String propertyKey){
        return propertiesFile.get(propertyKey);
    }


    private String convertPropertyObjectToString(Object propertyObject,String propertyKey) throws IOException {
        String value = propertyObject.toString();
        if (value.isEmpty()){
            throw new IOException("\nValue is not especified for key \"" + propertyKey + "\" in properties file.");
        }else{
            return value;
        }
    }

}
