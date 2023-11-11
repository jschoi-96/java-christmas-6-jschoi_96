package dto;

import enums.Menu;
import utils.Parser;
import validation.InputValidator;
import validation.MenuValidator;
import validation.RangeValidator;

import java.util.Map;

public class Order {

    private final Map<String, Integer> order;

    public Order(String input, Map<String, Integer> order) {
        validate(input);
        this.order = order;
    }

    private void validate(String input) {
        InputValidator.validateBlank(input);
        InputValidator.validateMenuFormat(input);
        Map<String, Integer> menuHashMap = Parser.convertToMenuHashMap(input);
        MenuValidator.validateNonMenu(menuHashMap);
        RangeValidator.validateMenuCountRange(menuHashMap);
    }


    public Map<String, Integer> getOrder() {
        return order;
    }
}
