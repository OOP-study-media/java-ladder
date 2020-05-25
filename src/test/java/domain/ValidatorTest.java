package domain;

import exception.Item.CountOfItemsException;
import exception.Item.LengthOfItemException;
import exception.Ladder.LengthOfHeightException;
import exception.Ladder.SearchTargetException;
import exception.Player.DuplicateNameOfPlayerException;
import exception.Player.LengthOfNameException;
import org.junit.jupiter.api.Test;
import util.ChangeStringToList;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ValidatorTest {
    private static final int NON_NATURAL_NUMBER = 0;

    @Test
    void 참가자_이름_5글자_초과시_예외발생_테스트() {
        assertThatExceptionOfType(LengthOfNameException.class)
                .isThrownBy(() -> Validator.isValidName("kimminsub"));
    }

    @Test
    void 참가자_이름_1글자_미만시_예외발생_테스트() {
        assertThatExceptionOfType(LengthOfNameException.class)
                .isThrownBy(() -> Validator.isValidName(""));
    }

    @Test
    void 참가자_이름_중복_테스트() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("kim"));

        assertThatExceptionOfType(DuplicateNameOfPlayerException.class)
                .isThrownBy(() -> Validator.isUniquePlayer(players, new Player("kim")));
    }

    @Test
    void 결과항목_개수_예외발생_테스트() {
        assertThatExceptionOfType(CountOfItemsException.class)
                .isThrownBy(() ->
                        Validator.checkResultItems(ChangeStringToList.changeStringToList("one,two,three"), 4));
    }

    @Test
    void 결과항목_이름_최소글자_예외발생_테스트() {
        assertThatExceptionOfType(LengthOfItemException.class)
                .isThrownBy(() ->
                        Validator.checkResultItems(ChangeStringToList.changeStringToList(",two,three"), 3));
    }

    @Test
    void 사다리_높이_예외발생_테스트() {
        assertThatExceptionOfType(LengthOfHeightException.class)
                .isThrownBy(() -> Validator.isValidHeight(NON_NATURAL_NUMBER));
    }

    @Test
    void 해당_이름의_참가자가_있는지_테스트() {
        PlayerRepository playerRepository = new PlayerRepository();

        playerRepository.addPlayer(new Player("kim"));

        assertThatExceptionOfType(SearchTargetException.class)
                .isThrownBy(() -> Validator.isValidSearchTarget("min", playerRepository));
    }
}