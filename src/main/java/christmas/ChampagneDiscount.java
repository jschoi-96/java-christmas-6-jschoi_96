package christmas;

import enums.core.Menu;

public class ChampagneDiscount {

    private static final int MINIMUM_PRIVILEGE_GIFT = 120000;

    public static int champagnePrice(int sum) {
        if (containsChampagne(sum)) {
            return Menu.샴페인.getPrice();
        }
        return 0;
    }
    public static boolean containsChampagne(int sum) {
        return sum >= MINIMUM_PRIVILEGE_GIFT;
    }
}
