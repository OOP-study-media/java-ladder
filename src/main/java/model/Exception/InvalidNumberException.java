package model.Exception;

public class InvalidNumberException extends NumberFormatException{
    public InvalidNumberException(String errorMessage) {
        super(errorMessage);
    }
}
