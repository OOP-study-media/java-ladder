package domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Player {
    private final String name;

    public Player(String name) {
        Validator.isValidName(name);
        this.name = name;
    }

    public Map<String, Integer> createPlayerResult(Map<String, Integer> result, List<Integer> matchedItems, int point) {
        result.put(name, matchedItems.get(point));
        return result;
    }

    public void addName(List<String> names) {
        names.add(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return name.equals(player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
