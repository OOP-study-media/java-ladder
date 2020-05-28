package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class LadderProvider {
    public static List<Line> getLadder(int ladderHeight, int nameCount, Function<Integer, List<Boolean>> random) {
        List<Line> ladder = new ArrayList<>();
        int pointCount = nameCount - 1;
        for (int i = 0; i < ladderHeight; i++) {
            ladder.add(makeLine(pointCount, random));
        }
        return Collections.unmodifiableList(ladder);
    }

    private static Line makeLine(int pointCount, Function<Integer, List<Boolean>> random) {
        List<Boolean> points = random.apply(pointCount);
        return new Line(points);
    }

}
