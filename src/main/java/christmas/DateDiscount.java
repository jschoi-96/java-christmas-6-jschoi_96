package christmas;

import dto.VisitDate;
import enums.core.Days;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateDiscount {

    private static final int START_DATE = 1;
    private static final int CURRENT_YEAR = 2023;
    private static final int CURRENT_MONTH = 12;

    public static void determineDayType(VisitDate visitDate) {
        int currentDate = visitDate.getVisitDate();
        for(int i = START_DATE; i <= currentDate; i++) {
            LocalDate dateObjects = LocalDate.of(CURRENT_YEAR, CURRENT_MONTH, i);
            DayOfWeek dayOfWeek = dateObjects.getDayOfWeek();

            Days day = Days.getDayOfWeek(dayOfWeek);
            weekdayDiscount(day);
            weekendDiscount(day);
        }
    }

    private static void weekdayDiscount(Days days) {
        if (isWeekday(days)){
            System.out.println("평일이다");
        }
    }

    private static void weekendDiscount(Days days) {
        if (isWeekend(days)){
            System.out.println("주말이다");
        }
    }

    private static boolean isWeekday(Days day) {
        return day.getDiscountType().equals("평일");
    }

    private static boolean isWeekend(Days day) {
        return day.getDiscountType().equals("주말");
    }

    public static void main(String[] args) {
        VisitDate visitDate = new VisitDate("14");
        DateDiscount.determineDayType(visitDate);
    }
}
