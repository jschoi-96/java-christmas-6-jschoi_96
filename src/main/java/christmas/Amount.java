package christmas;

import dto.VisitDate;
import enums.core.Menu;
import enums.Numbers;
import enums.OutputMessage;

import java.util.Map;

public class Amount {

    private int money;

    public Amount(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void subtractMoney(int amount) {
        money -= amount;
    }

    public static Amount totalPriceBeforeSale(Map<String,Integer> menuMap) {
        int sum = Numbers.DEFAULT_SUM.getNumbers();
        for (String menu : menuMap.keySet()) {
            sum += totalPrice(menu, menuMap.get(menu));
        }
        return new Amount(sum);
    }

    private static int totalPrice(String inputMenu, int count) {
        int totalPrice = Numbers.DEFAULT_SUM.getNumbers();
        for (Menu menu : Menu.values()){
            if (inputMenu.equals(menu.name())) {
                totalPrice += menu.getPrice() * count;
            }
        }
        return totalPrice;
    }

    public static int totalPaymentWithoutChampagne(VisitDate visitDate, int sum) {
        if (ChampagneDiscount.containsChampagne(sum)) {
            return sum - totalBenefitPrice(visitDate, sum) + Menu.샴페인.getPrice();
        }
        return sum;
    }

    public static int totalBenefitPrice(VisitDate visitDate, int sum) {
        DateDiscount dailyDiscount = DateDiscount.getDailyDiscount(visitDate);
        int christmasDiscountTotal= ChristmasDiscount.getChristmasDiscount(visitDate);
        int weekendDiscountTotal = dailyDiscount.getWeekendDiscountTotal();
        int weekdayDiscountTotal = dailyDiscount.getWeekdayDiscountTotal();
        int benefitTotal = christmasDiscountTotal + weekdayDiscountTotal + weekendDiscountTotal;

        benefitTotal = includesSpecialDiscount(benefitTotal);
        benefitTotal = includesChampagneGift(benefitTotal, sum);
        return benefitTotal;
    }

    public static int finalPriceAfterSale(VisitDate visitDate, int sum) {
        if (sum >= Numbers.MINIMUM_SALE_STANDARD.getNumbers()) {
            return totalBenefitPrice(visitDate, sum);
        }
        return 0;
    }

    private static int includesSpecialDiscount(int benefitTotal) {
        if (benefitTotal >= Numbers.MINIMUM_SPECIAL_STANDARD.getNumbers()) {
            benefitTotal += 1000;
        }
        return benefitTotal;
    }

    private static int includesChampagneGift(int benefitTotal, int sum) {
        if (sum >= Numbers.MINIMUM_PRIVILEGE_GIFT.getNumbers()) {
            benefitTotal += Menu.샴페인.getPrice();
        }
        return benefitTotal;
    }
}
