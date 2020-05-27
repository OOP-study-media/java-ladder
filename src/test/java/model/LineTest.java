package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    private Line line;
    private List<Boolean> points;

    @BeforeEach
    void setUp() {
        // given
        points = new ArrayList<>();
        points.add(true);
        points.add(false);
        points.add(true);
        line = new Line(points);
    }

    @Test
    void 연결됐는지_안됐는지_잘_되는지_테스트() {
        // when
        boolean firstPoint = line.connected(0);
        boolean secondPoint = line.connected(1);
        boolean thirdPoint = line.connected(2);

        // then
        assertThat(firstPoint).isTrue();
        assertThat(secondPoint).isFalse();
        assertThat(thirdPoint).isTrue();
    }

    @Test
    void 마지막_사다리_순서인지_테스트() {
        // given
        int location = points.size();

        // when
        boolean isLastLocation = line.isLastLocation(location);

        // then
        assertThat(isLastLocation).isTrue();
    }

    @Test
    void point_개수_잘_나오는지_테스트() {
        // when
        int pointCount = line.getPointCount();

        // then
        assertThat(pointCount).isEqualTo(points.size());
    }
}
