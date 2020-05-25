package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderCreator {
    private LadderCreator() {
        throw new AssertionError();
    }

    public static Ladder createLadder(PlayerRepository playerRepository, int ladderHeight, LadderCreatorStrategy strategy) {
        List<Line> ladder = new ArrayList<>();

        for (int i = 0; i < ladderHeight; i++) {
            ladder.add(new Line(createOneLine(playerRepository.getNumberOfPlayers(), strategy)));
        }

        return new Ladder(ladder);
    }

    private static List<Boolean> createOneLine(int numberOfPlayer, LadderCreatorStrategy strategy) {
        List<Boolean> points = new ArrayList<>();
        boolean horizonFlag = false;

        for (int i = 0; i < numberOfPlayer; i++) {
            horizonFlag = createHorizonFlag(i, numberOfPlayer, horizonFlag, strategy);
            points.add(horizonFlag);
        }

        return points;
    }

    private static boolean createHorizonFlag(int targetPoint, int numberOfPlayer, boolean prevHorizonFlag, LadderCreatorStrategy strategy) {
        if (prevHorizonFlag || isEnd(targetPoint, numberOfPlayer)) {
            return false;
        }

        return strategy.generate();
    }

    private static boolean isEnd(int targetPoint, int numberOfPlayer) {
        return targetPoint == numberOfPlayer - 1;
    }
}
