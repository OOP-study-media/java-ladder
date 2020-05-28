package model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomTest {

    @Test
    void 랜덤_사다리_한줄_잘_생성하는지_테스트() {
        // given
        int pointsCount = 3;

        // when
        List<Boolean> randomPoints = Random.getRandomPoints(pointsCount);

        // then
        assertThat(randomPoints).hasSize(3);
    }
}
