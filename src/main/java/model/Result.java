package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Result {
    public static List<Integer> getAllResults(List<Line> ladder, int nameCount) {
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < nameCount; i++) {
            results.add(getResult(ladder, i));
        }
        return Collections.unmodifiableList(results);
    }

    public static int getResult(List<Line> ladder, int start) {
        int location = start;
        for (Line line : ladder) {
            location = move(line, location);
        }
        return location;
    }

    private static int move(Line line, int current) {
        if (current == 0 && line.connected(current)) {
            return current + 1;
        }
        if (line.isLastLocation(current) && line.connected(current - 1)) {
            return current - 1;
        }
        if (current == 0 || line.isLastLocation(current)) {
            return current;
        }
        if (line.connected(current)) {
            return current + 1;
        }
        if (line.connected(current - 1)) {
            return current - 1;
        }
        return current;
    }
}
