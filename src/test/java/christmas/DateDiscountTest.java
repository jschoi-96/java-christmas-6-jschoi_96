package christmas;

import dto.VisitDate;
import enums.core.Days;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateDiscountTest {

    private VisitDate visitDate;
    private DateDiscount dateDiscount;

    @BeforeEach
    void setUp() {
        visitDate = new VisitDate("3");

    }

    @Test
    @DisplayName("평일 할인과 주말 할인 액수를 올바르게 리턴받는지 테스트")
    void test_correct_day() {
        DateDiscount dailyDiscount = DateDiscount.getDailyDiscount(visitDate);
        int weekday = dailyDiscount.weekdayDiscountTotal();
        int weekend = dailyDiscount.weekendDiscountTotal();
        assertEquals(4046, weekday);
        assertEquals(0, weekend);
    }

    @Test
    @DisplayName("주말 할인이 0이 아닐 떄 테스트")
    void test_when_weekend_not_0() {
        visitDate = new VisitDate("9");
        DateDiscount dailyDiscount = DateDiscount.getDailyDiscount(visitDate);
        int weekday = dailyDiscount.weekdayDiscountTotal();
        int weekend = dailyDiscount.weekendDiscountTotal();
        assertEquals(0, weekday);
        assertEquals(8092, weekend);
    }

}