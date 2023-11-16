package christmas;

import dto.Order;
import dto.VisitDate;
import enums.core.Days;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DateDiscountTest {

    private VisitDate visitDate;
    private Map<String, Integer> menuMap = new HashMap<>();
    private Order order;

    @BeforeEach
    void setUp() {
        visitDate = new VisitDate("3");
        String input = "티본스테이크-2,초코케이크-2";
        menuMap.put("티본스테이크", 2);
        menuMap.put("초코케이크", 2);
        order = new Order(input, menuMap);
    }

    @Test
    @DisplayName("평일 할인과 주말 할인 액수를 올바르게 리턴받는지 테스트")
    void test_correct_day() {
        DateDiscount dailyDiscount = DateDiscount.getDailyDiscount(visitDate, order);
        int weekday = dailyDiscount.weekdayDiscountTotal();
        int weekend = dailyDiscount.weekendDiscountTotal();
        assertEquals(4046, weekday);
        assertEquals(0, weekend);
    }

    @Test
    @DisplayName("주말 할인이 0이 아닐 떄 테스트")
    void test_when_weekend_not_0() {
        visitDate = new VisitDate("9");
        DateDiscount dailyDiscount = DateDiscount.getDailyDiscount(visitDate, order);
        int weekday = dailyDiscount.weekdayDiscountTotal();
        int weekend = dailyDiscount.weekendDiscountTotal();
        assertEquals(0, weekday);
        assertEquals(4046, weekend);
    }

}