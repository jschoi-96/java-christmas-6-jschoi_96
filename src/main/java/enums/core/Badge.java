package enums.core;

import dto.TotalDiscountDto;

public enum Badge {

    산타(20000),
    트리(10000),
    별(5000),
    없음(0);

    private final int benefitAmount;

    Badge(int benefitAmount) {
        this.benefitAmount = benefitAmount;
    }

    public int getBenefitAmount() {
        return benefitAmount;
    }
    public static String whichBadge(TotalDiscountDto totalDiscountDto) {
        int totalBenefits = totalDiscountDto.getTotalBenefits(totalDiscountDto);
        for (Badge badge : Badge.values()) {
            if (totalBenefits >= badge.getBenefitAmount()) {
                return badge.name();
            }
        }
        return Badge.없음.name();
    }
}
