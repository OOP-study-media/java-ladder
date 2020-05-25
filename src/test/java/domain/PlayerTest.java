package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

class PlayerTest {
    Player player;

    @BeforeEach
    void setUp() {
        player = new Player("kim");
    }

    @Test
    void 생성자_테스트() {
        assertThat(player).isNotNull();
    }

    @Test
    void 플레이어_당첨번호_매칭_테스트() {
        Map<String, Integer> gameResult = new HashMap<>();
        List<Integer> matchedItems = new ArrayList<>();

        matchedItems.add(500);

        Map<String, Integer> result = player.createPlayerResult(gameResult, matchedItems, 0);

        assertThat(result.get("kim")).isEqualTo(500);
    }

    @Test
    void 리스트에_이름_추가_테스트() {
        List<String> names = new ArrayList<>();

        names.add(player.getName());

        assertThat(names.get(0)).isEqualTo("kim");
    }
}