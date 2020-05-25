package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PlayerRepositoryTest {
    @Test
    void 참가자_추가_테스트() {
        PlayerRepository playerRepository = new PlayerRepository();

        playerRepository.addPlayer(new Player("kim"));

        assertThat(playerRepository.getPlayers().get(0).equals(new Player("kim"))).isTrue();
    }
}