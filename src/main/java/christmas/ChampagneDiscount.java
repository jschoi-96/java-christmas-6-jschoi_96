package christmas;

import enums.Numbers;
import enums.core.Menu;

public class ChampagneDiscount {

    private final int totalPrice;
    public ChampagneDiscount(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    public int getChampagnePrice() {
        return containsChampagne(totalPrice);
    }
    private int containsChampagne(int sum) {
        if (sum >= Numbers.MINIMUM_PRIVILEGE_GIFT.getNumbers()) {
            return Menu.샴페인.getPrice();
        }
        return Numbers.DEFAULT.getNumbers();
    }
}
