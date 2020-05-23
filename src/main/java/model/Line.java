package model;

import java.util.List;

public class Line {
    private List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public boolean connected(int index) {
        return points.get(index);
    }

    public boolean isLastLocation(int location) {
        return points.size() == location;
    }

    public int getPointCount() {
        return points.size();
    }
}
