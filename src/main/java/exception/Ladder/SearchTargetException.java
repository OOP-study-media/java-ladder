package exception.Ladder;

public class SearchTargetException extends RuntimeException {
    private static final String SEARCH_TARGET_ERROR_MESSAGE = "해당 이름을 가진 참가자가 없습니다.";

    public SearchTargetException() {
        super(SEARCH_TARGET_ERROR_MESSAGE);
    }
}
