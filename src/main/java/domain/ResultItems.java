package domain;

import java.util.Collections;
import java.util.List;

public class ResultItems {
    private final List<String> items;

    public ResultItems(List<String> items, int numberOfPlayers) {
        Validator.checkResultItems(items, numberOfPlayers);

        this.items = items;
    }

    public boolean checkItems(List<String> target) {
        return items.containsAll(target);
    }

    public List<String> getItems() {
        return Collections.unmodifiableList(items);
    }
}
