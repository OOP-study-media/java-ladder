package domain;

import exception.Item.CountOfItemsException;
import exception.Item.LengthOfItemException;
import exception.Ladder.LengthOfHeightException;
import exception.Ladder.SearchTargetException;
import exception.Player.DuplicateNameOfPlayerException;
import exception.Player.LengthOfNameException;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    private static final int MAX_LENGTH_OF_NAME = 5;
    private static final int MIN_LENGTH_OF_NAME = 1;
    private static final int MIN_LENGTH_OF_ITEM = 1;
    private static final int MIN_HEIGHT_OF_LADDER = 1;

    private Validator() {
        throw new AssertionError();
    }

    public static void isValidName(String name) {
        if (name.length() > MAX_LENGTH_OF_NAME || name.length() < MIN_LENGTH_OF_NAME) {
            throw new LengthOfNameException();
        }
    }

    public static void isUniquePlayer(List<Player> players, Player player) {
        if (players.contains(player)) {
            throw new DuplicateNameOfPlayerException();
        }
    }

    public static void checkResultItems(List<String> items, int numberOfPlayers) {
        if (items.size() != numberOfPlayers) {
            throw new CountOfItemsException();
        }

        for (String item : items) {
            checkItemLength(item);
        }
    }

    private static void checkItemLength(String item) {
        if (item.length() < MIN_LENGTH_OF_ITEM) {
            throw new LengthOfItemException();
        }
    }

    public static void isValidHeight(int height) {
        if (height < MIN_HEIGHT_OF_LADDER) {
            throw new LengthOfHeightException();
        }
    }

    public static void isValidSearchTarget(String searchTarget, PlayerRepository playerRepository) {
        List<String> names = new ArrayList<>();

        for (Player player : playerRepository.getPlayers()) {
            player.addName(names);
        }

        if (!names.contains(searchTarget)) {
            throw new SearchTargetException();
        }
    }
}
