package model;

import java.util.ArrayList;
import java.util.List;

public class Result {
    public static List<String> getAllResultItems(List<String> names, List<String> items, List<Integer> orders) {
        List<String> results = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            int order = orders.get(i);
            results.add(getResultItem(items, order));
        }
        return results;
    }

    public static String getResultItem(List<String> items, int order) {
        return items.get(order);
    }
}
