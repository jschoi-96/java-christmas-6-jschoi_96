package christmas;

import enums.core.Menu;
import enums.Numbers;

import java.util.Map;

public class Amount {

    private int money;
    public Amount(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
    public static int calculateUserMenuAndPrice(String inputMenu, int count) {
        int totalPrice = Numbers.DEFAULT.getNumbers();
        for (Menu menu : Menu.values()){
            if (inputMenu.equals(menu.name())) {
                totalPrice += menu.getPrice() * count;
            }
        }
        return totalPrice;
    }
    public static Amount totalPriceBeforeSale(Map<String,Integer> menuMap) {
        int sum = Numbers.DEFAULT.getNumbers();
        for (String menu : menuMap.keySet()) {
            sum += calculateUserMenuAndPrice(menu, menuMap.get(menu));
        }
        return new Amount(sum);
    }
}
