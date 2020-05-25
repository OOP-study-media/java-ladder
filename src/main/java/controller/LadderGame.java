package controller;

import domain.*;
import view.InputView;
import view.OutputView;

public class LadderGame {
    private static final String ALL_RESULT = "all";

    public void run() {
        PlayerRepository playerRepository = InputView.inputPlayersName();
        ResultItems resultItems = InputView.inputResultItems(playerRepository.getNumberOfPlayers());
        int ladderHeight = InputView.inputLadderHeight();

        Ladder ladder = LadderCreator.createLadder(playerRepository, ladderHeight, new RandomCreatorStrategy());

        OutputView.printLadder(playerRepository, ladder, resultItems);

        LadderResult ladderResult = new LadderResult(playerRepository, ladder);

        String searchName;

        do {
            searchName = InputView.inputSearchTarget(playerRepository);
            OutputView.printTargetResult(searchName, ladderResult, resultItems);
        } while (!searchName.equals(ALL_RESULT));
    }
}
