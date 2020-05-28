package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

public class DataProviderTest {
    private static final String ALL = "all";

    private List<String> names;

    @BeforeEach
    void setUp() {
        // given
        names = new ArrayList<>();
        names.add("은정");
        names.add("도원");
        names.add("민섭");
        names.add("동헌");
        names.add("태은");
    }

    @Test
    void 결과_볼_이름_all_일때_전체이름_나오는지_테스트() {
        // when
        List<String> resultNames = DataProvider.getResultNames(names, ALL);

        // then
        int size = names.size();
        assertThat(resultNames).hasSize(size)
                .contains("은정", "도원", "민섭", "동헌", "태은");
    }

    @Test
    void 결과_볼_이름_all_아닐_때_해당이름_나오는지_테스트() {
        // given
        String name = "은정";

        // when
        List<String> resultNames = DataProvider.getResultNames(names, name);

        // then
        assertThat(resultNames).hasSize(1)
                .contains("은정");
    }

    @Test
    void 결과_볼_이름_사다리_번호_잘_나오는지_테스트() {
        // given
        List<String> resultNames = new ArrayList<>();
        resultNames.add("태은");
        resultNames.add("민섭");
        resultNames.add("은정");
        resultNames.add("도원");
        resultNames.add("동헌");

        // when
        List<Integer> resultNameNumbers = DataProvider.getResultNameNumbers(names, resultNames);

        // then
        List<Integer> expectedNumbers = new ArrayList<>();
        expectedNumbers.add(4);
        expectedNumbers.add(2);
        expectedNumbers.add(0);
        expectedNumbers.add(1);
        expectedNumbers.add(3);

        assertThat(resultNameNumbers).isEqualTo(expectedNumbers);
    }
}
