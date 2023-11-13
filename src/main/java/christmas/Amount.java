package christmas;

import enums.Menu;
import enums.Numbers;
import enums.OutputMessage;

import java.util.Map;

public class Amount {

    private final int money;

    public Amount(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public static Amount totalPriceBeforeSale(Map<String,Integer> menuMap) {
        int sum = Numbers.DEFAULT_SUM.getNumbers();
        System.out.println(OutputMessage.PRICE_BEFORE_SALE.getOutputMessage());
        for (String menu : menuMap.keySet()) {
            sum += Menu.totalPrice(menu, menuMap.get(menu));
        }
        return new Amount(sum);
    }
}
