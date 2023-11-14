package dto;

import christmas.ChampagneDiscount;
import christmas.ChristmasDiscount;
import christmas.DateDiscount;

public class TotalDiscountDto {

    private final DateDiscount dateDiscount;
    private final ChristmasDiscount christmasDiscount;
    private final ChampagneDiscount champagneDiscount;

    public TotalDiscountDto(DateDiscount dateDiscount, ChristmasDiscount christmasDiscount, ChampagneDiscount champagneDiscount) {
        this.dateDiscount = dateDiscount;
        this.christmasDiscount = christmasDiscount;
        this.champagneDiscount = champagneDiscount;
    }

    public int getWeekdayDiscountTotal() {
        return dateDiscount.getWeekdayDiscountTotal();
    }

    public int getWeekendDiscountTotal() {
        return dateDiscount.getWeekendDiscountTotal();
    }

    public int getChristmasDiscount() {
        return christmasDiscount.getChristmasDiscount();
    }

    public int getChampagneDiscount() {
        return champagneDiscount.getChampagnePrice();
    }

    public int getSpecialDiscount(int benefitTotal) {
        if (benefitTotal >= 5000) {
            return 1000;
        }
        return 0;
    }
    public int getTotalBenefits(TotalDiscountDto totalDiscountDto) {
        int christmasDiscount = totalDiscountDto.getChristmasDiscount();
        int champagneDiscount = totalDiscountDto.getChampagneDiscount();
        int weekdayDiscount = totalDiscountDto.getWeekdayDiscountTotal();
        int weekendDiscount = totalDiscountDto.getWeekendDiscountTotal();
        int benefitTotal = christmasDiscount + champagneDiscount + weekendDiscount + weekdayDiscount;
        int specialDiscount = getSpecialDiscount(benefitTotal);
        return benefitTotal + specialDiscount;
    }
}
