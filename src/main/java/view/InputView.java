package view;

import domain.Player;
import domain.PlayerRepository;
import domain.ResultItems;
import domain.Validator;
import util.ChangeStringToList;

import java.util.List;
import java.util.Scanner;

import static view.OutputView.printErrorMessage;
import static view.OutputView.printMessage;

public class InputView {
    private static final String DEMAND_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표로 구분)";
    private static final String DEMAND_RESULT_ITEMS = "실행 결과를 입력하세요. (결과는 쉼표로 구분)";
    private static final String DEMAND_LADDER_HEIGHT = "최대 사다리 높이를 입력해주세요.";
    private static final String DEMAND_SEARCH_TARGET = "결과를 보고 싶은사람을 입력하시오.";
    private static final String ALL_RESULT = "all";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
        throw new AssertionError();
    }

    public static PlayerRepository inputPlayersName() {
        try {
            printMessage(DEMAND_NAMES);
            List<String> names = ChangeStringToList.changeStringToList(SCANNER.nextLine());
            PlayerRepository playerRepository = new PlayerRepository();

            for (String name : names) {
                playerRepository.addPlayer(new Player(name));
            }

            return playerRepository;
        } catch (Exception e) {
            printErrorMessage(e.getMessage());
            return inputPlayersName();
        }
    }

    public static ResultItems inputResultItems(int numberOfPlayers) {
        try {
            printMessage(DEMAND_RESULT_ITEMS);
            List<String> items = ChangeStringToList.changeStringToList(SCANNER.nextLine());
            return new ResultItems(items, numberOfPlayers);
        } catch (Exception e) {
            printErrorMessage(e.getMessage());
            return inputResultItems(numberOfPlayers);
        }
    }

    public static int inputLadderHeight() {
        try {
            printMessage(DEMAND_LADDER_HEIGHT);
            int height = SCANNER.nextInt();
            Validator.isValidHeight(height);
            return height;
        } catch (Exception e) {
            printErrorMessage(e.getMessage());
            return inputLadderHeight();
        }
    }

    public static String inputSearchTarget(PlayerRepository playerRepository) {
        try {
            printMessage(DEMAND_SEARCH_TARGET);
            String searchTarget = SCANNER.next();

            if (!searchTarget.equals(ALL_RESULT)) {
                Validator.isValidSearchTarget(searchTarget, playerRepository);
            }

            return searchTarget;
        } catch (Exception e) {
            printErrorMessage(e.getMessage());
            return inputSearchTarget(playerRepository);
        }
    }
}
