package vo;

import utils.Parser;
import utils.Validation;

public class DateVO {

    private final int visitDate;

    public DateVO(String input) {
        this.visitDate = validateDate(input);
    }

    private int validateDate(String input) {
        Validation.validateBlank(input);
        int parsedInput = Parser.convertToInt(input);
        Validation.validateRange(parsedInput);
        return parsedInput;
    }

    public int getVisitDate() {
        return visitDate;
    }
}
