package enums;

public enum Numbers {
    MIN_DATE(1),
    MAX_DATE(31),
    MIN_MENU_COUNT(1),
    MAX_MENU_COUNT(20),
    DEFAULT_SUM(0),
    MINIMUM_PRIVILEGE_GIFT(120000),
    MINIMUM_SALE_STANDARD(10000),
    MINIMUM_SPECIAL_STANDARD(5000)
    ;

    private final int numbers;

    Numbers(int numbers) {
        this.numbers = numbers;
    }

    public int getNumbers() {
        return numbers;
    }
}
