package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LadderCreatorTest {
    @Test
    void 사다리_만들기_테스트() {
        Line line;
        List<Line> manualLines = new ArrayList<>();
        Ladder ladder;
        PlayerRepository playerRepository = new PlayerRepository();

        line = new Line(Arrays.asList(true, false));
        manualLines.add(line);
        ladder = new Ladder(manualLines);
        playerRepository.addPlayer(new Player("kim"));
        playerRepository.addPlayer(new Player("min"));

        assertThat(LadderCreator.createLadder(playerRepository, 1, () -> true).equals(ladder)).isTrue();
    }
}