package enums.core;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.Map;

public enum Days {
    SUNDAY("평일"),
    MONDAY("평일"),
    TUESDAY("평일"),
    WEDNESDAY("평일"),
    THURSDAY("평일"),
    FRIDAY("주말"),
    SATURDAY("주말");

    private final String discountType;
    private static final String WEEKDAY = "평일";
    private static final String WEEKEND = "주말";
    Days(String discountType) {
        this.discountType = discountType;
    }

    public String getDiscountType() {
        return discountType;
    }

    private static final Map<DayOfWeek, Days> DISCOUNT_MAP = new EnumMap<>(DayOfWeek.class);

    static {
        DISCOUNT_MAP.put(DayOfWeek.SUNDAY, SUNDAY);
        DISCOUNT_MAP.put(DayOfWeek.MONDAY, MONDAY);
        DISCOUNT_MAP.put(DayOfWeek.TUESDAY, TUESDAY);
        DISCOUNT_MAP.put(DayOfWeek.WEDNESDAY, WEDNESDAY);
        DISCOUNT_MAP.put(DayOfWeek.THURSDAY, THURSDAY);
        DISCOUNT_MAP.put(DayOfWeek.FRIDAY, FRIDAY);
        DISCOUNT_MAP.put(DayOfWeek.SATURDAY, SATURDAY);
    }

    public static boolean isWeekday(Days day) {
        return day.getDiscountType().equals(WEEKDAY);
    }

    public static boolean isWeekend(Days day) {
        return day.getDiscountType().equals(WEEKEND);
    }

    public static Days getDayOfWeek(DayOfWeek dayOfWeek) {
        return DISCOUNT_MAP.get(dayOfWeek);
    }
}
