package utils;

import enums.Menu;

import java.util.*;

public class Parser {

    private static final String COMMA = ",";
    private static final String DELIMITER = "-";
    public static int convertToInt(String input) {
        return Integer.parseInt(input);
    }

    public static Map<String, Integer> extractMenuHashMap(String input){
        Map<String, Integer> menuHashMap = new HashMap<>();
        saveToHashMap(input, menuHashMap);
        return menuHashMap;
    }

    private static void saveToHashMap(String input, Map<String, Integer> menuHashMap) {
        String[] splitWithComma = input.split(COMMA);
        for (String item : splitWithComma) {
            String[] splitWithDelimiter = item.split(DELIMITER);
            String menu = splitWithDelimiter[0].trim();
            int count = convertToInt(splitWithDelimiter[1]);
            menuHashMap.put(menu, count);
        }
    }
}
