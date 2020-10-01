package vn.codegym.model;

import java.util.ArrayList;
import java.util.List;

public class BadWord {
    private static List<String> badWordList;
    static {
        badWordList = new ArrayList<>();
        badWordList.add("fuck");
        badWordList.add("shit");
        badWordList.add("holly shit");
        badWordList.add("dm");
    }

    public static List<String> getBadWordList() {
        return badWordList;
    }

    public static void setBadWordList(List<String> badWordList) {
        BadWord.badWordList = badWordList;
    }
}
