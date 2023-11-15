package view;

import dto.TotalDiscountDto;
import dto.Order;
import dto.VisitDate;
import enums.Numbers;
import enums.core.Badge;
import enums.core.Menu;
import enums.OutputMessage;

public class OutputView {

    private static final int CHAMPAGNE_REWARD_COUNT = 1;
    private static final int MINIMUM_EVENT_PRICE = 10000;
    private static final Menu CHAMPAGNE = Menu.샴페인;
    public static void printHelloMessage() {
        System.out.println(OutputMessage.HELLO_MESSAGE.getOutputMessage());
        System.out.println(OutputMessage.ASK_DATE.getOutputMessage());
    }
    public static void printMenuAndCount(){
        System.out.println(OutputMessage.ASK_MENU_AND_COUNT.getOutputMessage());
    }
    public static void printEventPreview(VisitDate visitDate){
        String formatted = String.format(OutputMessage.EVENT_PREVIEW.getOutputMessage(), visitDate.getVisitDate());
        System.out.println(formatted);
        System.out.println();
    }
    public static void printUserMenu(Order order) {
        System.out.println(OutputMessage.MENU_LIST.getOutputMessage());
        System.out.println(order.toString());
    }
    public static void printTotalPriceAndGift(int sum) {
        System.out.println(OutputMessage.PRICE_BEFORE_SALE.getOutputMessage());
        System.out.println(String.format("%d원", sum));
        System.out.println();
        System.out.println(OutputMessage.GIFT_MENU.getOutputMessage());
        if (sum >= Numbers.MINIMUM_PRIVILEGE_GIFT.getNumbers()) {
            String result = String.format("%s %d개", CHAMPAGNE.name(), CHAMPAGNE_REWARD_COUNT);
            System.out.println(result);
            return;
        }
        System.out.println(OutputMessage.NONE.getOutputMessage());
    }

    public static void printDiscountHistory(TotalDiscountDto totalDiscountDto, int total) {
        if (total >= MINIMUM_EVENT_PRICE) {
            System.out.println();
            System.out.println(OutputMessage.PRIVILEGE_HISTORY.getOutputMessage());
            System.out.println(String.format("크리스마스 디데이 할인: -%d원" , totalDiscountDto.getChristmasDiscount()));
            System.out.println(String.format("평일 할인: -%d원" , totalDiscountDto.getWeekdayDiscountTotal()));
            System.out.println(String.format("주말 할인: -%d원" , totalDiscountDto.getWeekendDiscountTotal()));
            System.out.println(String.format("특별 할인: -%d원" , totalDiscountDto.getSpecialDiscount(totalDiscountDto.getTotalBenefits(totalDiscountDto))));
            System.out.println(String.format("증정 이벤트: -%d원" , totalDiscountDto.getChampagneDiscount()));
            totalSalePrice(totalDiscountDto);
            totalPriceAfterSale(totalDiscountDto, total);
            decemberEventBadge(totalDiscountDto);
            return;
        }
        belowDiscountStandard(total);
    }
    public static void belowDiscountStandard(int total) {
        System.out.println("\n" + OutputMessage.PRIVILEGE_HISTORY.getOutputMessage() +
                "\n" + OutputMessage.NONE.getOutputMessage() +
                "\n\n" + OutputMessage.TOTAL_PRIVILEGE_PRICE.getOutputMessage() +
                "\n" + OutputMessage.NONE_DISCOUNT.getOutputMessage() +
                "\n\n" + OutputMessage.PRICE_AFTER_SALE.getOutputMessage() +
                String.format("%d원", total) +
                "\n\n" + OutputMessage.DECEMBER_EVENT_BADGE.getOutputMessage() +
                "\n" + OutputMessage.NONE.getOutputMessage());
    }
    public static void totalSalePrice(TotalDiscountDto totalDiscountDto) {
        System.out.println();
        System.out.println(OutputMessage.TOTAL_PRIVILEGE_PRICE.getOutputMessage());
        System.out.println(String.format("-%d원" , totalDiscountDto.getTotalBenefits(totalDiscountDto)));
    }

    public static void totalPriceAfterSale(TotalDiscountDto totalDiscountDto, int priceBeforeSale) {
        System.out.println();
        System.out.println(OutputMessage.PRICE_AFTER_SALE.getOutputMessage());
        int totalBenefit = totalDiscountDto.getTotalBenefits(totalDiscountDto);
        if (totalDiscountDto.getChampagneDiscount() > Numbers.DEFAULT.getNumbers()) {
            totalBenefit -= totalDiscountDto.getChampagneDiscount();
        }
        System.out.println(String.format("%d원" , priceBeforeSale - totalBenefit));
    }
    public static void decemberEventBadge(TotalDiscountDto totalDiscountDto) {
        System.out.println();
        System.out.println(OutputMessage.DECEMBER_EVENT_BADGE.getOutputMessage());
        System.out.println(Badge.whichBadge(totalDiscountDto));
    }
}
