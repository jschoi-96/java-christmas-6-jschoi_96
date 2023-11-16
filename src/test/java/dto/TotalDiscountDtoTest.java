package dto;

import christmas.TotalAmount;
import christmas.ChampagneDiscount;
import christmas.ChristmasDiscount;
import christmas.DateDiscount;
import enums.core.Badge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TotalDiscountDtoTest {

    private TotalDiscountDto totalDiscountDto;
    private Map<String, Integer> menuMap = new HashMap<>();
    private Order order;
    @BeforeEach
    void setUp() {
        String input = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        menuMap.put("티본스테이크", 1);
        menuMap.put("바비큐립", 1);
        menuMap.put("초코케이크", 2);
        menuMap.put("제로콜라", 1);
        order = new Order(input, menuMap);
        initializeTotalDiscountDto("3", 142000, order);
    }

    private void initializeTotalDiscountDto(String visitDate, int amount, Order order) {
        VisitDate date = new VisitDate(visitDate);
        TotalAmount amountObj = new TotalAmount(amount);
        DateDiscount dateDiscount = DateDiscount.getDailyDiscount(date, order);
        ChristmasDiscount christmasDiscount = ChristmasDiscount.totalChristmasDiscount(date);
        ChampagneDiscount champagneDiscount = new ChampagneDiscount(amountObj.getMoney());
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
        initializeTotalDiscountDto("3", 119999, order);
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

    @Test
    @DisplayName("총 혜택 금액이 2만원 이상일 때 뱃지가 산타인지 테스트")
    void test_when_returns_santa_badge() {
        String badge = Badge.whichBadge(totalDiscountDto);
        assertEquals("산타" , badge);
    }

    @Test
    @DisplayName("총 혜택 금액이 5천원 이상 10000원 미만일 때 뱃지가 별인지 테스트")
    void test_when_returns_star_badge() {
        initializeTotalDiscountDto("3", 119999, order);
        String badge = Badge.whichBadge(totalDiscountDto);
        assertEquals("별", badge);
    }
}