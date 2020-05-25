package domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public boolean checkHorizonFlag(int point) {
        return points.get(point);
    }

    public List<Boolean> getLine() {
        return Collections.unmodifiableList(points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return points.equals(line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
