package domain;

import java.util.List;
import java.util.Objects;

public class Ladder {
    private static final int START_POINT = 0;

    private final List<Line> ladder;

    public Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public int goDown(int point) {
        int itemNumber = point;

        for (int i = 0; i < ladder.size(); i++) {
            itemNumber = updateItemNumber(i, itemNumber);
        }

        return itemNumber;
    }

    private int updateItemNumber(int lineNumber, int itemNumber) {
        int updateNumber = itemNumber;

        if (ladder.get(lineNumber).checkHorizonFlag(updateNumber)) {
            updateNumber++;
            return updateNumber;
        }

        return checkStratPoint(lineNumber, updateNumber);
    }

    private int checkStratPoint(int lineNumber, int updateNumber) {
        if (updateNumber == START_POINT) {
            return updateNumber;
        }

        return checkPreviousPoint(lineNumber, updateNumber);
    }

    private int checkPreviousPoint(int lineNumber, int updateNumber) {
        if (ladder.get(lineNumber).checkHorizonFlag(updateNumber - 1)) {
            updateNumber--;
            return updateNumber;
        }

        return updateNumber;
    }

    public Line getLine(int point) {
        return ladder.get(point);
    }

    public int getHeight() {
        return ladder.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder1 = (Ladder) o;
        return ladder.equals(ladder1.ladder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladder);
    }
}
