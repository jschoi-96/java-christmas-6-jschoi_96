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

    public static void printEventList(int sum) {
        String formatted = String.format("%d원", sum);
        System.out.println(formatted);
    }
}
