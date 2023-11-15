package dto;

import christmas.Amount;
import christmas.ChampagneDiscount;
import christmas.ChristmasDiscount;
import christmas.DateDiscount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TotalDiscountDtoTest {

    private VisitDate visitDate;
    private Amount amount;
    private DateDiscount dateDiscount;
    private ChristmasDiscount christmasDiscount;
    private ChampagneDiscount champagneDiscount;
    private TotalDiscountDto totalDiscountDto;

    @BeforeEach
    void setUp() {
        VisitDate visitDate = new VisitDate("3");
        Amount amount = new Amount(142000);
        DateDiscount dateDiscount = DateDiscount.getDailyDiscount(visitDate);
        ChristmasDiscount christmasDiscount = ChristmasDiscount.totalChristmasDiscount(visitDate);
        ChampagneDiscount champagneDiscount = new ChampagneDiscount(amount.getMoney());
        totalDiscountDto = new TotalDiscountDto(dateDiscount, christmasDiscount, champagneDiscount);
    }

    @Test
    @DisplayName("올바르게 총 할인 값을 리턴받는지 테스트")
    void test_when_correct_total_benefit() {
        int totalBenefits = totalDiscountDto.getTotalBenefits(totalDiscountDto);
        assertEquals(31246, totalBenefits);
    }


    @Test
    @DisplayName("총 금액이 120000원 이하일 때 총 할인 값에는 샴페인 가격이 포함되지 않는지 테스트")
    void test_without_champagne_price() {
        VisitDate visitDate = new VisitDate("3");
        Amount amount = new Amount(119999);
        DateDiscount dateDiscount = DateDiscount.getDailyDiscount(visitDate);
        ChristmasDiscount christmasDiscount = ChristmasDiscount.totalChristmasDiscount(visitDate);
        ChampagneDiscount champagneDiscount = new ChampagneDiscount(amount.getMoney());
        totalDiscountDto = new TotalDiscountDto(dateDiscount, christmasDiscount, champagneDiscount);
        int totalBenefits = totalDiscountDto.getTotalBenefits(totalDiscountDto);
        assertEquals(6246, totalBenefits);
    }

    @Test
    @DisplayName("총 혜택 금액이 5천원 이상일 떄 특별 할인 1000원이 적용되는지 테스트")
    void test_when_special_discount_applies() {
        int specialDiscount = totalDiscountDto.getSpecialDiscount(5000);
        assertEquals(1000, specialDiscount);
    }

    @Test
    @DisplayName("총 혜택 금액이 5천원 미만일 때 특별 할인이 적용되지 않아야 한다")
    void test_when_special_discount_does_not_applies() {
        int specialDiscount = totalDiscountDto.getSpecialDiscount(3000);
        assertEquals(0, specialDiscount);
    }
}