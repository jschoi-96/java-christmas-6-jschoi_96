package christmas;

import enums.Numbers;
import enums.core.Menu;

public class ChampagneDiscount {


    public static int champagnePrice(int sum) {
        if (containsChampagne(sum)) {
            return Menu.샴페인.getPrice();
        }
        return 0;
    }
    public static boolean containsChampagne(int sum) {
        return sum >= Numbers.MINIMUM_PRIVILEGE_GIFT.getNumbers();
    }
}
