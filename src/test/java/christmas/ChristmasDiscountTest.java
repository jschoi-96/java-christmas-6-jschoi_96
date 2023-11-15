package christmas;

import dto.VisitDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChristmasDiscountTest {

    private VisitDate visitDate;

    @BeforeEach
    void setUp() {
        visitDate = new VisitDate("3");
    }

    @Test
    @DisplayName("해당 날짜에 맞는 크리스마스 디데이 할인 날짜를 올바르게 가져오는지 테스트")
    void test_christmas_event_days() {
        int christmasDiscountDays = ChristmasDiscount.getChristmasDiscountDays(visitDate);
        assertEquals(2, christmasDiscountDays);
    }

    @Test
    @DisplayName("방문 날짜가 크리스마스 이벤트가 끝난 후라면, 25일 까지만 계산한다")
    void test_christmas_event_days_after_25() {
        visitDate = new VisitDate("31");
        int christmasDiscountDays = ChristmasDiscount.getChristmasDiscountDays(visitDate);
        assertEquals(25, christmasDiscountDays);
    }

    @Test
    @DisplayName("해당 날짜에 맞는 올바른 할인 금액을 리턴하는지 테스트")
    void test_correct_christmas_event_discount() {
        ChristmasDiscount christmasDiscount = ChristmasDiscount.totalChristmasDiscount(visitDate);
        int totalDiscount = christmasDiscount.getChristmasDiscount();
        assertEquals(1200, totalDiscount);
    }

}