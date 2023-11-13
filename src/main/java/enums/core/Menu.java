package enums.core;

import enums.Numbers;

public enum Menu {

    양송이수프("에피타이저", 6000, 0, 0),
    티파스("에피타이저", 5500, 0, 0),
    시저샐러드("에피타이저", 8000, 0, 0),
    티본스테이크("메인", 55000, 2023, 0),
    바비큐립("메인", 54000, 2023, 0),
    해산물파스타("메인", 35000, 2023, 0),
    크리스마스파스타("메인", 25000, 2023, 0),
    초코케이크("디저트", 15000, 0, 2023),
    아이스크림("디저트", 5000, 0, 2023),
    제로콜라("음료", 3000, 0, 0),
    레드와인("음료", 60000, 0, 0),
    샴페인("음료", 25000, 0, 0);

    private final String category;
    private final int price;
    private final int weekdayDiscount;
    private final int weekendDiscount;

    Menu(String category, int price, int discountOnWeekday, int discountOnWeekend) {
        this.category = category;
        this.price = price;
        this.weekdayDiscount = discountOnWeekday;
        this.weekendDiscount = discountOnWeekend;
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    public int getWeekdayDiscount() {
        return weekdayDiscount;
    }

    public int getWeekendDiscount() {
        return weekendDiscount;
    }

    public static int totalPrice(String inputMenu, int count) {
        int totalPrice = Numbers.DEFAULT_SUM.getNumbers();
        for (Menu menu : Menu.values()){
            if (inputMenu.equals(menu.name())) {
                totalPrice += menu.getPrice() * count;
            }
        }
        return totalPrice;
    }

    public static int weekdayDiscountTotal() {
        return 0;
    }

    public static int weekendDiscountTotal() {
        return 0;
    }
}
