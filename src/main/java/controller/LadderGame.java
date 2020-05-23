package controller;

import model.LadderProvider;
import model.Line;
import model.PlayLadder;
import model.Result;
import ui.Input;
import ui.Output;

import java.util.List;

public class LadderGame {
    private static final String ALL = "all";
    private static final String BLANK = " ";
    private static final String RESULT_MESSAGE = "실행 결과";

    private List<String> names;
    private List<String> items;
    private List<Line> ladder;

    public void run() throws Exception {
        names = Input.inputNames();
        items = Input.inputItems();
        int ladderHeight = Input.inputLadderHeight();

        ladder = LadderProvider.getLadder(ladderHeight, names.size());
        Output.printLadder(ladder, names, items);

        String resultName = Input.inputGetResultName();
        Output.printMessage(BLANK);
        Output.printMessage(RESULT_MESSAGE);
        chooseResult(resultName, names.size());
    }

    private void chooseResult(String name, int nameCount) {
        if (name.equals(ALL)) {
            List<String> resultItems = getAllResultItems(nameCount);
            Output.printResultItems(names, resultItems);
            return;
        }
        String resultItem = getResultItem(names.indexOf(name));
        Output.printMessage(resultItem);
    }

    private List<String> getAllResultItems(int nameCount) {
        List<Integer> ladderNumbers = PlayLadder.getAllLadderNumber(ladder, nameCount);
        return Result.getAllResultItems(names, items, ladderNumbers);
    }

    private String getResultItem(int nameOrder) {
        int ladderNumber = PlayLadder.getLadderNumber(ladder, nameOrder);
        return Result.getResultItem(items, ladderNumber);
    }
}
