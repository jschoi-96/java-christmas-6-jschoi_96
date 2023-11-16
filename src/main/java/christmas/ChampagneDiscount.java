package christmas;

import enums.Numbers;
import enums.core.Menu;

public class ChampagneDiscount {

    private static final Menu CHAMPAGNE = Menu.샴페인;
    private final int totalAmount;
    public ChampagneDiscount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
    public int getChampagnePrice() {
        return containsChampagne(totalAmount);
    }
    private int containsChampagne(int sum) {
        if (sum >= Numbers.MINIMUM_PRIVILEGE_GIFT.getNumbers()) {
            return CHAMPAGNE.getPrice();
        }
        return Numbers.DEFAULT.getNumbers();
    }
}
