package view;

import domain.*;

import java.util.Map;

public class OutputView {
    private static final String GAME_REULST = "사다리 결과";
    private static final String HORIZON_LINE = "-----";
    private static final String VERTICAL_LINE = "|";
    private static final String SPACE = "     ";
    private static final String ALL_RESULT = "all";

    private OutputView() {
        throw new AssertionError();
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printErrorMessage(String message) {
        System.err.println(message);
    }

    public static void printLadder(PlayerRepository playerRepository, Ladder ladder, ResultItems resultItems) {
        printMessage(GAME_REULST);
        printPlayers(playerRepository);
        printLadder(ladder);
        printResultItmes(resultItems);
    }

    private static void printPlayers(PlayerRepository playerRepository) {
        for (Player player : playerRepository.getPlayers()) {
            System.out.printf("%6s", player.getName());
        }

        System.out.println();
    }

    private static void printLadder(Ladder ladder) {
        for (int i = 0; i < ladder.getHeight(); i++) {
            printOneLine(ladder.getLine(i));
            System.out.println();
        }
    }

    private static void printOneLine(Line line) {
        System.out.print(SPACE);

        for (int i = 0; i < line.getLine().size(); i++) {
            System.out.print(VERTICAL_LINE);

            if (!line.getLine().get(i)) {
                System.out.print(SPACE);
                continue;
            }

            System.out.print(HORIZON_LINE);
        }
    }

    private static void printResultItmes(ResultItems resultItems) {
        for (String item : resultItems.getItems()) {
            System.out.printf("%6s", item);
        }

        System.out.println();
    }

    public static void printTargetResult(String searchName, LadderResult ladderResult, ResultItems resultItems) {
        if (searchName.equals(ALL_RESULT)) {
            printAllResult(ladderResult, resultItems);
            return;
        }

        Map<String, Integer> result = ladderResult.getGameResult();
        int resultItemNumber = result.get(searchName);

        System.out.println(searchName + " : " + resultItems.getItems().get(resultItemNumber));
    }

    private static void printAllResult(LadderResult ladderResult, ResultItems resultItems) {
        Map<String, Integer> result = ladderResult.getGameResult();

        for (String name : result.keySet()) {
            System.out.println(name + " : " + resultItems.getItems().get(result.get(name)));
        }
    }
}
