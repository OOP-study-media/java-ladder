package exception.Item;

public class LengthOfItemException extends RuntimeException {
    private static final String LENGTH_OF_ITEM_ERROR_MESSAGE = "결과 항목은 최대 한글자 이상이어야 합니다.";

    public LengthOfItemException() {
        super(LENGTH_OF_ITEM_ERROR_MESSAGE);
    }
}
