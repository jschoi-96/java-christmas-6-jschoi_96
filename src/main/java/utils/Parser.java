package utils;

import enums.ErrorMessage;
import enums.Numbers;
import validation.InputValidator;
import validation.MenuValidator;
import validation.RangeValidator;

import java.util.*;

public class Parser {

    private static final String COMMA = ",";
    private static final String DELIMITER = "-";

    public static int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MENU_INPUT_LENGTH.getErrorMessage());
        }
    }
    public static Map<String, Integer> convertToMenuHashMap(String input){
        Map<String, Integer> menuHashMap = new LinkedHashMap<>();
        saveToHashMap(input, menuHashMap);
        return menuHashMap;
    }
    private static void saveToHashMap(String input, Map<String, Integer> menuHashMap) {
        String[] splitWithComma = input.trim().split(COMMA);
        int totalMenuCount = Numbers.DEFAULT.getNumbers();
        for (String item : splitWithComma) {
            String[] splitWithDelimiter = item.split(DELIMITER);
            InputValidator.validateLengthAfterParse(splitWithDelimiter);
            String menu = splitWithDelimiter[0];
            int menuCount = convertToInt(splitWithDelimiter[1]);
            MenuValidator.validateDuplicateMenu(menuHashMap, menu);
            menuHashMap.put(menu, menuHashMap.getOrDefault(menu, Numbers.DEFAULT.getNumbers()) + menuCount);
            totalMenuCount += menuCount;
        }
        RangeValidator.validateMaximumMenuCount(totalMenuCount);
    }
}
