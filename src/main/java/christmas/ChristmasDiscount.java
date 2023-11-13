package christmas;

import dto.VisitDate;

public class ChristmasDiscount {

    private static final int START_DISCOUNT = 1000;
    private static final int EVENT_START_DATE = 1;
    private static final int EVENT_END_DATE = 25;
    private static final int DISCOUNT_RATE = 100;

    public static int getChristmasDiscountDays(VisitDate visitDate) {
        int playerVisitDate = visitDate.getVisitDate();
        if (playerVisitDate > EVENT_END_DATE) {
            return EVENT_END_DATE;
        }
        return playerVisitDate - EVENT_START_DATE;
    }

    public static int getChristmasDiscount(VisitDate visitDate) {
        int christmasDiscountDays = getChristmasDiscountDays(visitDate);
        return START_DISCOUNT + DISCOUNT_RATE * christmasDiscountDays;
    }
}
