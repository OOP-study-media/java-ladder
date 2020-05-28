package model.Exception;

import java.security.InvalidParameterException;

public class InvalidResultNameException extends InvalidParameterException {
    public InvalidResultNameException(String errorMessage) {
        super(errorMessage);
    }
}
