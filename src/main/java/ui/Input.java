package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {
    private static final String COMMA = ",";
    private static final String INPUT_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_RESULT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void printMessage(String message) {
        System.out.println(message);
    }

    private static List<String> inputListSplitWithComma() throws Exception {
        String[] names = br.readLine().split(COMMA);
        return new ArrayList<>(Arrays.asList(names));
    }

    public static List<String> inputNames() throws Exception {
        printMessage(INPUT_NAMES_MESSAGE);
        return inputListSplitWithComma();
    }

    public static List<String> inputResult() throws Exception {
        printMessage(INPUT_RESULT_MESSAGE);
        return inputListSplitWithComma();
    }

    public static int inputLadderHeight() throws Exception {
        String input = br.readLine();
        return Integer.parseInt(input);
    }

    public static String inputGetResultName() throws Exception {
        return br.readLine();
    }

}
