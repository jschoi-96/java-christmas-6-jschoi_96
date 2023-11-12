package christmas;

import dto.Order;
import enums.Menu;
import enums.Numbers;
import enums.OutputMessage;

import java.util.Map;

public class PrivilegeMenu {

    private static final int MINIMUM_PRIVILEGE_GIFT = 120000;
    private final Order order;

    public PrivilegeMenu(Order order) {
        this.order = order;
    }

    public static boolean containsChampagne(int sum) {
        if (sum >= MINIMUM_PRIVILEGE_GIFT) {
            return true;
        }
        return false;
    }

    public static int totalPriceBeforeSale(Map<String,Integer> menuMap) {
        int sum = Numbers.DEFAULT_SUM.getNumbers();
        System.out.println(OutputMessage.PRICE_BEFORE_SALE.getOutputMessage());
        for (String menu : menuMap.keySet()) {
            sum += Menu.totalPrice(menu, menuMap.get(menu));
        }
        return sum;
    }
}
