package christmas;

import dto.VisitDate;
import enums.core.Days;
import enums.core.Menu;

import java.time.DayOfWeek;
import java.time.LocalDate;

public record DateDiscount(int weekdayDiscountTotal, int weekendDiscountTotal) {

    private static final int START_DATE = 1;
    private static final int CURRENT_YEAR = 2023;
    private static final int DISCOUNT_RATE = 2023;
    private static final int CURRENT_MONTH = 12;
    private static final String DESSERT = "디저트";
    private static final String MAIN = "메인";
    private static int calculateWeekdayDiscount(Days day) {
        int discount = 0;
        for (Menu menu : Menu.values()) {
            if (Days.isWeekday(day) && menu.getCategory().equals(DESSERT)) {
                discount += DISCOUNT_RATE;
            }
        }
        return discount;
    }

    private static int calculateWeekendDiscount(Days day) {
        int discount = 0;
        for (Menu menu : Menu.values()) {
            if (Days.isWeekend(day) && menu.getCategory().equals(MAIN)) {
                discount += DISCOUNT_RATE;
            }
        }
        return discount;
    }
    public static DateDiscount getDailyDiscount(VisitDate visitDate) {
        int currentDate = visitDate.getVisitDate();
        int weekdayDiscount = 0;
        int weekendDiscount = 0;
        for (int i = START_DATE; i <= currentDate; i++) {
            LocalDate dateObjects = LocalDate.of(CURRENT_YEAR, CURRENT_MONTH, i);
            DayOfWeek dayOfWeek = dateObjects.getDayOfWeek();
            Days day = Days.getDayOfWeek(dayOfWeek);
            weekdayDiscount = calculateWeekdayDiscount(day);
            weekendDiscount = calculateWeekendDiscount(day);
        }
        return new DateDiscount(weekdayDiscount, weekendDiscount);
    }
}
