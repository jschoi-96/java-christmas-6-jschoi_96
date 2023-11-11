package utils;

import eums.ErrorMessage;
import eums.OutputMessage;

public class Validation {

    private static final int MIN_DATE = 1;
    private static final int MAX_DATE = 31;

    public static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_INPUT.getErrorMessage());
        }
    }

    public static void validateRange(int date) {
        if (date < MIN_DATE || date > MAX_DATE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE.getErrorMessage());
        }
    }
}
