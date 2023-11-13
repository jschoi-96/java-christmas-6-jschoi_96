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

    public static int totalBenefitPrice(VisitDate visitDate, int total) {
        DateDiscount dailyDiscount = DateDiscount.getDailyDiscount(visitDate);
        int christmasDiscountTotal= ChristmasDiscount.getChristmasDiscount(visitDate);
        int weekendDiscountTotal = dailyDiscount.getWeekendDiscountTotal();
        int weekdayDiscountTotal = dailyDiscount.getWeekdayDiscountTotal();
        int benefitTotal = christmasDiscountTotal + weekdayDiscountTotal + weekendDiscountTotal;
        if (total >= Numbers.MINIMUM_PRIVILEGE_GIFT.getNumbers()) {
            benefitTotal += Menu.샴페인.getPrice();
        }
        return benefitTotal;
    }
}
