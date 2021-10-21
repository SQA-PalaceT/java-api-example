package mavenpackage.reusableComponents;

public class NoSuchElementCustomException extends Exception{

    public NoSuchElementCustomException(String message,Throwable e){
        super(message,e);
    }
    
}
