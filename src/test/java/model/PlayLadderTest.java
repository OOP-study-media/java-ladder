package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayLadderTest {

    @Test
    void 사다리_잘_타는지_테스트() {
        // given
        List<Line> ladder = new ArrayList<>();
        List<Boolean> points = new ArrayList<>();
        List<Integer> namesNumbers = new ArrayList<>();
        points.add(true);
        points.add(false);
        points.add(true);
        ladder.add(new Line(points));

        points = new ArrayList<>();
        points.add(false);
        points.add(true);
        points.add(false);
        ladder.add(new Line(points));

        points = new ArrayList<>();
        points.add(true);
        points.add(false);
        points.add(false);
        ladder.add(new Line(points));

        namesNumbers.add(2);
        namesNumbers.add(3);
        namesNumbers.add(0);
        namesNumbers.add(1);

        // when
        List<Integer> matchNumbers = PlayLadder.getMatchNumbers(ladder, namesNumbers);

        // then
        List<Integer> expectedNumbers = new ArrayList<>();
        expectedNumbers.add(3);
        expectedNumbers.add(0);
        expectedNumbers.add(2);
        expectedNumbers.add(1);
        assertThat(matchNumbers).isEqualTo(expectedNumbers);
    }
}
