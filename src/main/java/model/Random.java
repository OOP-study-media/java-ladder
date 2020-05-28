package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Random {
    public static List<Boolean> getRandomPoints(int pointsCount) {
        List<Boolean> points = new ArrayList<>();
        points.add(randomBoolean());

        for (int i = 1; i < pointsCount; i++) {
            addRandomPoint(points, i);
        }
        return Collections.unmodifiableList(points);
    }

    private static boolean randomBoolean() {
        return new java.util.Random().nextBoolean();
    }

    private static void addRandomPoint(List<Boolean> points, int currentPoint) {
        boolean checkPreviousPoint = points.get(currentPoint - 1);
        if (checkPreviousPoint) {
            points.add(false);
            return;
        }
        points.add(randomBoolean());
    }
}
