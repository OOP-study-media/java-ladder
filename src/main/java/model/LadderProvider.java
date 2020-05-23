package model;

import java.util.ArrayList;
import java.util.List;

public class LadderProvider {
    public List<Line> getLadder(int ladderHeight, int nameCount) {
        List<Line> ladder = new ArrayList<>();

        int pointCount = nameCount - 1;
        for (int i = 0; i < ladderHeight; i++) {
            ladder.add(makeLine(pointCount));
        }
        return ladder;
    }

    private Line makeLine(int pointCount) {
        List<Boolean> points = Random.getRandomPoints(pointCount);
        return new Line(points);
    }

}
