package validation;

import enums.ErrorMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    private static final String regExp = "^[0-9]+$";
    private static final Pattern NUMBER = Pattern.compile(regExp);
    public static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_INPUT.getErrorMessage());
        }
    }
    public static void validateNonNumber(String input) {
        Matcher matcher = NUMBER.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getErrorMessage());
        }
    }
}
