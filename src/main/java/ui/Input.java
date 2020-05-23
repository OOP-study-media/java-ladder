package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {
    private static final String COMMA = ",";
    private static final String BLANK = " ";
    private static final String INPUT_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_ITEM_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_RESULT_NAME_MESSAGE = "결과를 보고 싶은 사람은?";

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static List<String> inputListSplitWithComma() throws Exception {
        String[] names = br.readLine().split(COMMA);
        return new ArrayList<>(Arrays.asList(names));
    }

    public static List<String> inputNames() throws Exception {
        Output.printMessage(INPUT_NAMES_MESSAGE);
        return inputListSplitWithComma();
    }

    public static List<String> inputItems() throws Exception {
        Output.printMessage(INPUT_ITEM_MESSAGE);
        return inputListSplitWithComma();
    }

    public static int inputLadderHeight() throws Exception {
        Output.printMessage(INPUT_LADDER_HEIGHT_MESSAGE);
        String input = br.readLine();
        return Integer.parseInt(input);
    }

    public static String inputGetResultName() throws Exception {
        Output.printMessage(BLANK);
        Output.printMessage(INPUT_RESULT_NAME_MESSAGE);
        return br.readLine();
    }

}
