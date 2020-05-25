package model;

import java.util.ArrayList;
import java.util.List;

public class Result {
    public static List<String> getMatchItems(List<String> items, List<Integer> matchNumbers) {
        List<String> results = new ArrayList<>();
        for (int matchNumber : matchNumbers) {
            String item = items.get(matchNumber);
            results.add(item);
        }
        return results;
    }
}
