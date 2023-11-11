package validation;

import enums.ErrorMessage;

public class RangeValidator {

    private static final int MIN_DATE = 1;
    private static final int MAX_DATE = 31;

    public static void validateDateRange(int date) {
        if (date < MIN_DATE || date > MAX_DATE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE.getErrorMessage());
        }
    }
}
