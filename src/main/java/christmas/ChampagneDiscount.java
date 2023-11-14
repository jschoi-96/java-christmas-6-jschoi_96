package christmas;

import enums.Numbers;
import enums.core.Menu;

public class ChampagneDiscount {

    private int sum;

    public ChampagneDiscount(int sum) {
        this.sum = sum;
    }
    public int getChampagnePrice() {
        return ifContainsChampagne(sum);
    }

    public int ifContainsChampagne(int sum) {
        if (containsChampagne(sum)) {
            return Menu.샴페인.getPrice();
        }
        return 0;
    }
    public boolean containsChampagne(int sum) {
        return sum >= Numbers.MINIMUM_PRIVILEGE_GIFT.getNumbers();
    }
}
