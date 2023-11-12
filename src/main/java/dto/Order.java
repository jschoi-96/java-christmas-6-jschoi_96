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
        RangeValidator.validateMenuCountRange(menuHashMap);
        MenuValidator.validateNonMenu(menuHashMap);
        MenuValidator.validateOnlyDrink(menuHashMap);
    }
    public Map<String, Integer> getOrder() {
        return Map.copyOf(order);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            stringBuilder.append(String.format("%s %d개\n", entry.getKey(), entry.getValue()));
        }
        return stringBuilder.toString();
    }
}
