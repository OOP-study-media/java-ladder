package model.Exception;

import java.security.InvalidParameterException;

public class InvalidItemSizeException extends InvalidParameterException {
    public InvalidItemSizeException(String errorMessage) {
        super(errorMessage);
    }
}
