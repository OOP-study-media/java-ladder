package exception.Player;

public class DuplicateNameOfPlayerException extends RuntimeException {
    private static final String DUPLICATE_NAME_OF_PLAYER_ERROR_MESSAGE = "중복된 참가자 이름이 있으면 안됩니다.";

    public DuplicateNameOfPlayerException() {
        super(DUPLICATE_NAME_OF_PLAYER_ERROR_MESSAGE);
    }
}
