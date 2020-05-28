package model.Exception;

import java.security.InvalidParameterException;

public class InvalidNameLengthException extends InvalidParameterException {
    public InvalidNameLengthException(String errorMessage) {
        super(errorMessage);
    }
}
