package ui;

import model.Line;

import java.util.List;

public class Output {
    private static final int INTERVAL_COUNT = 5;
    private static final String LADDER_RESULT = "사다리 결과";
    private static final String BLANK = " ";
    private static final String ROW = "-";
    private static final String COLUMN = "|";
    private static final String LINE_BREAK = "\n";

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printLadder(List<Line> ladder, List<String> names, List<String> results) {
        printMessage(BLANK);
        printMessage(LADDER_RESULT);
        printMessage(BLANK);
        printMessage(getPrintedString(names));
        printMessage(getPrintedLadder(ladder));
        printMessage(getPrintedString(results));
    }

    private static String getPrintedString(List<String> strings) {
        StringBuilder printedString = new StringBuilder();
        for (String string : strings) {
            printedString.append(string);
            printedString.append(BLANK.repeat(INTERVAL_COUNT - string.length() + 1));
        }
        return printedString.toString();
    }

    private static String getPrintedLadder(List<Line> ladder) {
        StringBuilder printedLadder = new StringBuilder();
        for (Line line : ladder) {
            String printedLine = getPrintedLine(line);
            printedLadder.append(printedLine);
            printedLadder.append(LINE_BREAK);
        }
        printedLadder.delete(printedLadder.length() - 1, printedLadder.length());
        return printedLadder.toString();
    }

    private static String getPrintedLine(Line line) {
        List<Boolean> points = line.getPoints();
        StringBuilder printedLine = new StringBuilder();

        for (Boolean point : points) {
            printedLine.append(COLUMN);
            printedLine.append(getPrintedPoint(point));
        }
        printedLine.append(COLUMN);
        return printedLine.toString();
    }

    private static String getPrintedPoint(Boolean point) {
        if (point) {
            return ROW.repeat(INTERVAL_COUNT);
        }
        return BLANK.repeat(INTERVAL_COUNT);
    }
}
