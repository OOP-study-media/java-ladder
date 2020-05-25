package exception.Item;

public class CountOfItemsException extends RuntimeException {
    private static final String COUNT_OF_ITEMS_ERROR_MESSAGE = "결과 항목의 수는 참가자 인원과 같아야 합니다.";

    public CountOfItemsException() {
        super(COUNT_OF_ITEMS_ERROR_MESSAGE);
    }
}
