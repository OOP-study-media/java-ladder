package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderProviderTest {

    @Test
    void 사다리_잘_만들어지는지_테스트() {
        // given
        int ladderHeight = 10;
        int nameCount = 4;
        List<Boolean> points = new ArrayList<>();
        points.add(true);
        points.add(false);
        points.add(true);
        Function<Integer, List<Boolean>> random = pointCount -> points;

        // when
        List<Line> ladder = LadderProvider.getLadder(ladderHeight, nameCount, random);

        // then
        for (int i = 0; i < ladderHeight; i++) {
            Line line = ladder.get(i);
            boolean firstConnected = line.connected(0);
            boolean secondConnected = line.connected(1);
            boolean thirdConnected = line.connected(2);

            assertThat(firstConnected).isTrue();
            assertThat(secondConnected).isFalse();
            assertThat(thirdConnected).isTrue();
        }
    }
}
