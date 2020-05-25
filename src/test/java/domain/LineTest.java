package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LineTest {
    private Line line;

    @BeforeEach
    void setUp() {
        List<Boolean> lineMembers = Arrays.asList(true, false);

        line = new Line(lineMembers);
    }

    @Test
    void 해당_포인트에서_수평선_있는경우() {
        int point = 0;

        assertThat(line.checkHorizonFlag(point)).isTrue();
    }

    @Test
    void 해당_포인트에서_수평선_없는경우() {
        int point = 1;

        assertThat(line.checkHorizonFlag(point)).isFalse();
    }
}