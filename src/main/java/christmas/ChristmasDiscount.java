package christmas;

import dto.VisitDate;

public class ChristmasDiscount {

    private static final int START_DISCOUNT = 1000;
    private static final int EVENT_START_DATE = 1;
    private static final int EVENT_END_DATE = 25;
    private static final int DISCOUNT_RATE = 100;

    private final int christmasDiscount;
    public ChristmasDiscount(int christmasDiscount) {
        this.christmasDiscount = christmasDiscount;
    }

    public int getChristmasDiscount() {
        return christmasDiscount;
    }

    private static int getChristmasDiscountDays(VisitDate visitDate) {
        int playerVisitDate = visitDate.getVisitDate();
        if (playerVisitDate > EVENT_END_DATE) {
            return EVENT_END_DATE;
        }
        return playerVisitDate - EVENT_START_DATE;
    }

    public static ChristmasDiscount totalChristmasDiscount(VisitDate visitDate) {
        int christmasDiscountDays = getChristmasDiscountDays(visitDate);
        int totalDiscount = START_DISCOUNT + DISCOUNT_RATE * christmasDiscountDays;
        return new ChristmasDiscount(totalDiscount);
    }
}
