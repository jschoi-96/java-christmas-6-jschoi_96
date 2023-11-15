package dto;

import utils.Parser;
import validation.InputValidator;
import validation.RangeValidator;

public class VisitDate {

    private final int visitDate;
    public VisitDate(String input) {
        this.visitDate = validateDate(input);
    }
    private int validateDate(String input) {
        InputValidator.validateBlank(input);
        InputValidator.validateNonNumber(input);
        int parsedInput = Parser.convertToInt(input);
        RangeValidator.validateDateRange(parsedInput);
        return parsedInput;
    }
    public int getVisitDate() {
        return visitDate;
    }
}
