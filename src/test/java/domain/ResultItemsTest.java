package domain;

import org.junit.jupiter.api.Test;
import util.ChangeStringToList;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ResultItemsTest {
    @Test
    void 생성자_테스트() {
        List<String> items = ChangeStringToList.changeStringToList("kim,min,sub");
        ResultItems resultItems = new ResultItems(items, 3);

        assertThat(resultItems.checkItems(items)).isTrue();
    }
}