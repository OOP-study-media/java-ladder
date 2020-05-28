package controller;

import ui.Input;

import java.util.List;

public class InputSetting {
    private static final String ALL = "all";

    public static List<String> setupNames() throws Exception {
        List<String> names = Input.inputNames();
        InputValidator.checkInputNames(names);
        return names;
    }

    public static List<String> setupItems(int nameCount) throws Exception {
        List<String> items = Input.inputItems();
        int itemCount = items.size();
        InputValidator.checkMatchNameAndItemCount(nameCount, itemCount);
        return items;
    }

    public static int setupHeight() throws Exception {
        String inputHeight = Input.inputLadderHeight();
        InputValidator.checkHeight(inputHeight);
        return Integer.parseInt(inputHeight);
    }

    public static String setupResultName(List<String> names) throws Exception {
        String resultName = Input.inputGetResultName();
        if (!resultName.equals(ALL)) {
            InputValidator.checkResultName(names, resultName);
        }
        return resultName;
    }
}
