package christmas;

import dto.VisitDate;

public class Badge {

    private static final int MINIMUM_BADGE_PRICE = 5000;
    private final int specialDiscount;

    public Badge(int specialDiscount) {
        this.specialDiscount = specialDiscount;
    }

    public int getSpecialDiscount() {
        return specialDiscount;
    }

    public static int meetBadgeStandard(VisitDate visitDate, int total) {
        int totalBenefitPrice = Amount.totalBenefitPrice(visitDate, total);
        if (totalBenefitPrice >= MINIMUM_BADGE_PRICE) {
            return 1000;
        }
        return 0;
    }
}
