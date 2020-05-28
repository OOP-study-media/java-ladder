package model;

import model.Exception.InvalidItemSizeException;
import model.Exception.InvalidNameLengthException;
import model.Exception.InvalidNumberException;
import model.Exception.InvalidResultNameException;

import java.util.List;

public class Validator {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;
    private static final String INVALID_MAX_NAME_LENGTH_MESSAGE = "글자 수는 5자 이하여야 합니다.";
    private static final String INVALID_MIN_NAME_LENGTH_MESSAGE = "글자 수는 1자 이상이여야 합니다.";
    private static final String INVALID_ITEM_SIZE_MESSAGE = "실행 결과는 사람 이름 수와 같아야 합니다.";
    private static final String INVALID_RESULT_NAME_MESSAGE = "결과 확인 이름이 이름 목록에 없습니다.";
    private static final String INVALID_NUMBER_MESSAGE = "숫자가 아닙니다.";

    public static void checkNameLength(String name) {
        checkMaxNameLength(name);
        checkMinNameLength(name);
    }

    private static void checkMaxNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new InvalidNameLengthException(INVALID_MAX_NAME_LENGTH_MESSAGE);
        }
    }

    private static void checkMinNameLength(String name) {
        if (name.length() < MIN_NAME_LENGTH) {
            throw new InvalidNameLengthException(INVALID_MIN_NAME_LENGTH_MESSAGE);
        }
    }

    public static void matchNamesAndItemsSize(int nameCount, int itemCount) {
        if (nameCount != itemCount) {
            throw new InvalidItemSizeException(INVALID_ITEM_SIZE_MESSAGE);
        }
    }

    public static void checkNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException(INVALID_NUMBER_MESSAGE);
        }
    }

    public static void checkContainsName(List<String> names, String name) {
        if (!names.contains(name)) {
            throw new InvalidResultNameException(INVALID_RESULT_NAME_MESSAGE);
        }
    }
}
