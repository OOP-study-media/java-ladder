package util;

import java.util.Arrays;
import java.util.List;

public class ChangeStringToList {
    public static List<String> changeStringToList(String target) {
        return Arrays.asList(target.trim().split(","));
    }
}
