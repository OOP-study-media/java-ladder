package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LadderResultTest {
    @Test
    void 참가자와_아이템번호_매칭_테스트() {
        PlayerRepository playerRepository = new PlayerRepository();
        Line line = new Line(Arrays.asList(true, false));
        List<Line> lines = new ArrayList<>();

        playerRepository.addPlayer(new Player("kim"));
        playerRepository.addPlayer(new Player("min"));
        lines.add(line);

        Ladder ladder = new Ladder(lines);

        LadderResult ladderResult = new LadderResult(playerRepository, ladder);

        assertThat(ladderResult.getGameResult().get("kim")).isEqualTo(1);
        assertThat(ladderResult.getGameResult().get("min")).isEqualTo(0);
    }
}