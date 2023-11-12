package view;

import dto.Order;
import dto.VisitDate;
import enums.Menu;
import enums.Numbers;
import enums.OutputMessage;

import java.util.Map;

public class OutputView {

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

    public static void printEventList(Map<String,Integer> menuMap) {
        int sum = Numbers.DEFAULT_SUM.getNumbers();
        System.out.println(OutputMessage.PRICE_BEFORE_SALE.getOutputMessage());
        for (String menu : menuMap.keySet()) {
            sum += Menu.totalPrice(menu, menuMap.get(menu));
        }
        System.out.println(sum);
    }
}
