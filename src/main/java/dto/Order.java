package dto;

import enums.Menu;
import validation.MenuValidator;

import java.util.Map;

public class Order {

    private final Map<String, Integer> order;

    public Order(Map<String, Integer> order) {
        validate(order);
        this.order = order;
    }

    private void validate(Map<String, Integer> order) {
        MenuValidator.validateNonMenu(order);
    }

    public Map<String, Integer> getOrder() {
        return order;
    }
}
