package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayLadder {
    public static List<Integer> getMatchNumbers(List<Line> ladder, List<Integer> nameNumbers) {
        List<Integer> ladderNumbers = new ArrayList<>();
        for (int nameNumber : nameNumbers) {
            ladderNumbers.add(getMatchNumber(ladder, nameNumber));
        }
        return Collections.unmodifiableList(ladderNumbers);
    }

    public static int getMatchNumber(List<Line> ladder, int start) {
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
