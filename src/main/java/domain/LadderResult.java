package domain;

import java.util.*;

public class LadderResult {
    private static final int START_POINT = 0;

    private final Map<String, Integer> gameResult;

    public LadderResult(PlayerRepository playerRepository, Ladder ladder) {
        List<Integer> matchedItems = playLadderGame(playerRepository, ladder);

        this.gameResult = createGameResult(playerRepository, matchedItems);
    }

    private List<Integer> playLadderGame(PlayerRepository playerRepository, Ladder ladder) {
        List<Integer> resultItemNumbers = new ArrayList<>();

        for (int point = 0; point < playerRepository.getNumberOfPlayers(); point++) {
            int resultAtPoint = ladder.goDown(point);
            resultItemNumbers.add(resultAtPoint);
        }

        return resultItemNumbers;
    }

    private Map<String, Integer> createGameResult(PlayerRepository playerRepository, List<Integer> matchedItems) {
        int point = START_POINT;
        Map<String, Integer> result = new LinkedHashMap<>();
        List<Player> players = playerRepository.getPlayers();

        for (Player player : players) {
            result = player.createPlayerResult(result, matchedItems, point);
            point++;
        }

        return result;
    }

    public Map<String, Integer> getGameResult() {
        return Collections.unmodifiableMap(gameResult);
    }
}
