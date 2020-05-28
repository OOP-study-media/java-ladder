package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @Test
    void 아이템_잘_매치되는지_테스트() {
        // given
        List<String> items = new ArrayList<>();
        items.add("꽝1");
        items.add("꽝2");
        items.add("꽝3");
        items.add("꽝4");

        List<Integer> matchNumbers = new ArrayList<>();
        matchNumbers.add(1);
        matchNumbers.add(3);
        matchNumbers.add(0);
        matchNumbers.add(2);

        // when
        List<String> matchItems = Result.getMatchItems(items, matchNumbers);

        // then
        List<String> expectedItems = new ArrayList<>();
        expectedItems.add("꽝2");
        expectedItems.add("꽝4");
        expectedItems.add("꽝1");
        expectedItems.add("꽝3");
        assertThat(matchItems).isEqualTo(expectedItems);
    }
}
