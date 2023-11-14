package view;

import dto.Order;
import dto.VisitDate;
import enums.core.Menu;
import enums.OutputMessage;

public class OutputView {

    private static final int CHAMPAGNE_REWARD_COUNT = 1;
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

    public static void printEventList(int sum) {
        System.out.println(OutputMessage.PRICE_BEFORE_SALE.getOutputMessage());
        System.out.println(String.format("%d원", sum));
        System.out.println();
        System.out.println(OutputMessage.GIFT_MENU.getOutputMessage());
    }

    public static void printChampagnePrize(boolean containsChampagne) {
        if (containsChampagne) {
            String result = String.format("%s %d개", Menu.샴페인.name(), CHAMPAGNE_REWARD_COUNT);
            System.out.println(result);
            return;
        }
        System.out.println(OutputMessage.NONE.getOutputMessage());
    }

    public static void christmasDiscount(int discount){
        System.out.println();
        System.out.println(OutputMessage.PRIVILEGE_HISTORY.getOutputMessage());
        System.out.println(String.format("크리스마스 디데이 할인: -%d원" , discount));
    }

    public static void weekdayDiscount(int discount) {
        System.out.println(String.format("평일 할인: -%d원" , discount));
    }

    public static void weekendDiscount(int discount){
        System.out.println(String.format("주말 할인: -%d원" , discount));
    }

    public static void specialDiscount(int discount) {
        System.out.println(String.format("특별 할인: -%d원" , discount));
    }

    public static void privilegeDiscount(int discount) {
        System.out.println(String.format("증정 이벤트: -%d원" , discount));
    }

    public static void belowPrivilegeStandard(int total) {
        System.out.println();
        System.out.println(OutputMessage.PRIVILEGE_HISTORY.getOutputMessage());
        System.out.println(OutputMessage.NONE.getOutputMessage());

    }

    public static void totalSalePrice(int discount) {
        System.out.println();
        System.out.println(OutputMessage.TOTAL_PRIVILEGE_PRICE.getOutputMessage());
        System.out.println(String.format("-%d원" , discount));
    }

    public static void totalPriceAfterSale(int finalAmount) {
        System.out.println();
        System.out.println(OutputMessage.PRICE_AFTER_SALE.getOutputMessage());
        System.out.println(String.format("%d원" , finalAmount));
    }

    public static void decemberEventBadge(String badge) {
        System.out.println();
        System.out.println(OutputMessage.DECEMBER_EVENT_BADGE.getOutputMessage());
        System.out.println(badge);
    }
}
