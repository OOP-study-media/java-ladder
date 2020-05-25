package controller;

import model.*;
import ui.Output;

import java.util.List;

public class LadderGame {
    private static final String BLANK = " ";
    private static final String RESULT_MESSAGE = "실행 결과";

    public void start() throws Exception {
        List<String> names = InputSetting.setupNames();
        List<String> items = InputSetting.setupItems(names.size());
        int ladderHeight = InputSetting.setupHeight();

        List<Line> ladder = LadderProvider.getLadder(ladderHeight, names.size());
        Output.printLadder(ladder, names, items);

        String resultName = InputSetting.setupResultName(names);
        Output.printMessage(BLANK);
        Output.printMessage(RESULT_MESSAGE);

        List<String> resultNames = DataProvider.getResultNames(names, resultName);
        List<Integer> nameNumbers = DataProvider.getResultNameNumbers(names, resultNames);
        List<Integer> matchNumbers = DataProvider.getMatchNumbers(ladder, nameNumbers);
        List<String> matchItems = DataProvider.getMatchItems(items, matchNumbers);
        Output.printResultItems(resultNames, matchItems);
    }
}
