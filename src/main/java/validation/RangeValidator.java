package validation;

import enums.ErrorMessage;
import enums.Numbers;

import java.util.Map;

public class RangeValidator {

    public static void validateDateRange(int date) {
        if (date < Numbers.MIN_DATE.getNumbers() || date > Numbers.MAX_DATE.getNumbers()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DATE_RANGE.getErrorMessage());
        }
    }

    public static void validateMenuCountRange(Map<String, Integer> menuMap) {
        for (Integer count : menuMap.values()) {
            validateMenuCountRangeHelper(count);
        }
    }
    private static void validateMenuCountRangeHelper(int count) {
        if (count < Numbers.MIN_MENU_COUNT.getNumbers()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MENU_COUNT_RANGE.getErrorMessage());
        }
    }

    public static void validateMaximumMenuCount(int count){
        if (count > Numbers.MAX_MENU_COUNT.getNumbers()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MENU_INPUT_LENGTH.getErrorMessage());
        }
    }
}
