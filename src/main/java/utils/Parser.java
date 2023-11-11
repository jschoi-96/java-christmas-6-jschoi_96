package utils;

import enums.Menu;
import validation.MenuValidator;

import java.util.*;

public class Parser {

    private static final String COMMA = ",";
    private static final String DELIMITER = "-";

    public static int convertToInt(String input) {
        return Integer.parseInt(input);
    }

    public static Map<String, Integer> convertToMenuHashMap(String input){
        Map<String, Integer> menuHashMap = new LinkedHashMap<>();
        saveToHashMap(input, menuHashMap);
        return menuHashMap;
    }
    private static void saveToHashMap(String input, Map<String, Integer> menuHashMap) {
        String[] splitWithComma = input.split(COMMA);
        for (String item : splitWithComma) {
            String[] splitWithDelimiter = item.split(DELIMITER);
            String menu = splitWithDelimiter[0].trim();
            int count = convertToInt(splitWithDelimiter[1]);
            MenuValidator.validateDuplicateMenu(menuHashMap, menu);
            menuHashMap.put(menu, count);
        }
    }
}
