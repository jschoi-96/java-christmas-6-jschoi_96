package enums.date;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.Map;

public enum Days {
    SUNDAY("평일", 2023),
    MONDAY("평일", 2023),
    TUESDAY("평일", 2023),
    WEDNESDAY("평일", 2023),
    THURSDAY("평일", 2023),
    FRIDAY("주말", 2023),
    SATURDAY("주말", 2023);

    private final String discountType;
    private final int discountAmount;

    Days(String discountType, int discountAmount) {
        this.discountType = discountType;
        this.discountAmount = discountAmount;
    }

    public String getDiscountType() {
        return discountType;
    }

    public int getDiscountAmount() {
        return discountAmount;
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

    public static Days getDayOfWeek(DayOfWeek dayOfWeek) {
        return DISCOUNT_MAP.get(dayOfWeek);
    }
}
