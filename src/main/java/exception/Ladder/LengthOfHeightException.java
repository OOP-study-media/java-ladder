package exception.Ladder;

public class LengthOfHeightException extends RuntimeException {
    private static final String LENGTH_OF_HEIGHT_ERROR_MESSAGE = "사다리의 높이는 1 이상이어야 합니다.";

    public LengthOfHeightException() {
        super(LENGTH_OF_HEIGHT_ERROR_MESSAGE);
    }
}
