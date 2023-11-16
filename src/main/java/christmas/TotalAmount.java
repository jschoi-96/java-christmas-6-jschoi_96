package christmas;

import enums.core.Menu;
import enums.Numbers;

import java.util.Map;

public class TotalAmount {

    private int money;
    public TotalAmount(int money) {
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
    public static TotalAmount totalPriceBeforeSale(Map<String,Integer> menuMap) {
        int sum = Numbers.DEFAULT.getNumbers();
        for (String menu : menuMap.keySet()) {
            sum += calculateUserMenuAndPrice(menu, menuMap.get(menu));
        }
        return new TotalAmount(sum);
    }
}
