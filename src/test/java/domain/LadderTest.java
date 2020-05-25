package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LadderTest {
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        List<Line> lines = new ArrayList<>();
        Line line;

        line = new Line(Arrays.asList(true, false));
        lines.add(line);
        ladder = new Ladder(lines);
    }

    @Test
    void 생성자_테스트() {
        Line line = new Line(Arrays.asList(true, false));
        assertThat(ladder.getLine(0).equals(line)).isTrue();
    }

    @Test
    void 사다리게임_진행_테스트() {
        PlayerRepository playerRepository = new PlayerRepository();

        playerRepository.addPlayer(new Player("one"));
        playerRepository.addPlayer(new Player("two"));

        assertThat(LadderCreator.createLadder(playerRepository, 1, () -> true)).isEqualTo(ladder);
    }

    @Test
    void 사다리_진행시_매칭아이템번호_반환_테스트() {
        assertThat(ladder.goDown(0)).isEqualTo(1);
    }
}