package model;

import model.Exception.InvalidItemSizeException;
import model.Exception.InvalidNameLengthException;
import model.Exception.InvalidNumberException;
import model.Exception.InvalidResultNameException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {
    private static final String INVALID_MAX_NAME_LENGTH_MESSAGE = "글자 수는 5자 이하여야 합니다.";
    private static final String INVALID_MIN_NAME_LENGTH_MESSAGE = "글자 수는 1자 이상이여야 합니다.";
    private static final String INVALID_ITEM_SIZE_MESSAGE = "실행 결과는 사람 이름 수와 같아야 합니다.";
    private static final String INVALID_RESULT_NAME_MESSAGE = "결과 확인 이름이 이름 목록에 없습니다.";
    private static final String INVALID_NUMBER_MESSAGE = "숫자가 아닙니다.";

    @Test
    void 이름_길이_5초과_테스트() {
        // given
        String name = "123456";

        assertThatThrownBy(() -> Validator.checkNameLength(name))
                .isInstanceOf(InvalidNameLengthException.class)
                .hasMessageContaining(INVALID_MAX_NAME_LENGTH_MESSAGE);
    }

    @Test
    void 이름_길이_0일때_테스트() {
        // given
        String name = "";

        assertThatThrownBy(() -> Validator.checkNameLength(name))
                .isInstanceOf(InvalidNameLengthException.class)
                .hasMessageContaining(INVALID_MIN_NAME_LENGTH_MESSAGE);
    }

    @Test
    void 이름_길이_1이상_5이하일때_테스트() {
        // given
        String name = "12345";

        assertThatCode(() -> Validator.checkNameLength(name))
                .doesNotThrowAnyException();
    }

    @Test
    void 이름개수와_아이템개수_같을_때_테스트() {
        // given
        int nameCount = 4;
        int itemCount = 4;

        assertThatCode(() -> Validator.matchNamesAndItemsSize(nameCount, itemCount))
                .doesNotThrowAnyException();
    }

    @Test
    void 이름개수와_아이템개수_다를_때_테스트() {
        // given
        int nameCount = 4;
        int itemCount = 3;

        assertThatThrownBy(() -> Validator.matchNamesAndItemsSize(nameCount, itemCount))
                .isInstanceOf(InvalidItemSizeException.class)
                .hasMessageContaining(INVALID_ITEM_SIZE_MESSAGE);
    }

    @Test
    void 사다리_높이_입력_숫자일때_테스트() {
        // given
        String height = "10";

        assertThatCode(() -> Validator.checkNumber(height))
                .doesNotThrowAnyException();
    }

    @Test
    void 사다리_높이_입력_숫자_아닐때_테스트() {
        // given
        String height = "십";

        assertThatThrownBy(() -> Validator.checkNumber(height))
                .isInstanceOf(InvalidNumberException.class)
                .hasMessageContaining(INVALID_NUMBER_MESSAGE);
    }

    @Test
    void 결과_볼_이름_배열에_포함되어있을때_테스트() {
        // given
        List<String> names = new ArrayList<>();
        names.add("은정");
        names.add("태은");
        names.add("도원");
        names.add("동헌");
        names.add("민섭");
        String name = "은정";

        assertThatCode(() -> Validator.checkContainsName(names, name))
                .doesNotThrowAnyException();
    }

    @Test
    void 결과_볼_이름_배열에_포함_안되어있을때_테스트() {
        // given
        List<String> names = new ArrayList<>();
        names.add("은정");
        names.add("태은");
        names.add("도원");
        names.add("동헌");
        names.add("민섭");
        String name = "은정정";

        assertThatThrownBy(() -> Validator.checkContainsName(names, name))
                .isInstanceOf(InvalidResultNameException.class)
                .hasMessageContaining(INVALID_RESULT_NAME_MESSAGE);
    }
}
