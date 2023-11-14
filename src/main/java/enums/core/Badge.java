package enums.core;

import christmas.Amount;
import dto.VisitDate;

public enum Badge {

    산타(20000),
    트리(10000),
    별(5000);

    private final int benefitAmount;

    Badge(int benefitAmount) {
        this.benefitAmount = benefitAmount;
    }

    public int getBenefitAmount() {
        return benefitAmount;
    }

    private static final int MINIMUM_BADGE_PRICE = 5000;

    public static int meetBadgeStandard(VisitDate visitDate) {
        int totalBenefitPrice = Amount.totalBenefitPrice(visitDate);
        if (totalBenefitPrice >= MINIMUM_BADGE_PRICE) {
            return 1000;
        }
        return 0;
    }

    public static String whichBadge(int totalBenefit) {
        for (Badge badge : Badge.values()) {
            if (totalBenefit >= badge.getBenefitAmount()) {
                return badge.name();
            }
        }
    }
}
