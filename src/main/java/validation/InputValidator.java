package validation;

import enums.ErrorMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    private static final int MINIMUM_MENU_LENGTH = 2;
    private static final String NUMBER_REG_EXP = "^[0-9]+$";
    private static final String MENU_REG_EXP = "^([^,]+)-(\\d+)(?:,([^,]+)-(\\d+))*$";
    private static final Pattern NUMBER = Pattern.compile(NUMBER_REG_EXP);
    private static final Pattern MENU = Pattern.compile(MENU_REG_EXP);
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
    public static void validateMenuFormat(String input) {
        Matcher matcher = MENU.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MENU_FORMAT.getErrorMessage());
        }
    }

    public static void validateLengthAfterParse(String [] splitWithDelimiter){
        if (splitWithDelimiter.length != MINIMUM_MENU_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MENU_INPUT_LENGTH.getErrorMessage());
        }
    }
}
