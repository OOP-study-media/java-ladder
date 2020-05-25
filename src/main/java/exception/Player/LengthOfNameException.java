package exception.Player;

public class LengthOfNameException extends RuntimeException {
    private static final String LENGTH_OF_NAME_ERROR_MESSGAE = "이름은 1글자 이상 5글자 이하여야 합니다.";

    public LengthOfNameException() {
        super(LENGTH_OF_NAME_ERROR_MESSGAE);
    }
}
