package controller;

import model.Exception.InvalidItemSizeException;
import model.Exception.InvalidNameLengthException;
import model.Exception.InvalidNumberException;
import model.Exception.InvalidResultNameException;
import model.Validator;
import ui.Output;

import java.util.List;

public class InputValidator {
    private static final int EXIT_INVALID_INPUT = 1;

    public static void checkInputNames(List<String> names) {
        for (String name : names) {
            checkNameLength(name);
        }
    }

    private static void checkNameLength(String name) {
        try {
            Validator.checkNameLength(name);
        } catch (InvalidNameLengthException e) {
            exitProgram(e.getMessage());
        }
    }

    public static void checkMatchNameAndItemCount(int nameCount, int itemCount) {
        try {
            Validator.matchNamesAndItemsSize(nameCount, itemCount);
        } catch (InvalidItemSizeException e) {
            exitProgram(e.getMessage());
        }
    }

    public static void checkHeight(String height) {
        try {
            Validator.checkNumber(height);
        } catch (InvalidNumberException e) {
            exitProgram(e.getMessage());
        }
    }

    public static void checkResultName(List<String> names, String resultName) {
        try {
            Validator.checkContainsName(names, resultName);
        } catch (InvalidResultNameException e) {
            exitProgram(e.getMessage());
        }
    }

    private static void exitProgram(String exitMessage) {
        Output.printMessage(exitMessage);
        System.exit(EXIT_INVALID_INPUT);
    }

}
