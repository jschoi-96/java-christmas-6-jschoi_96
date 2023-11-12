package view;

import enums.OutputMessage;

public class OutputView {

    public static void printHelloMessage() {
        System.out.println(OutputMessage.HELLO_MESSAGE.getOutputMessage());
        System.out.println(OutputMessage.ASK_DATE.getOutputMessage());
    }

    public static void printMenuAndCount(){
        System.out.println(OutputMessage.ASK_MENU_AND_COUNT.getOutputMessage());
    }

    public static void printEventPreview(int date){
        String formatted = String.format(OutputMessage.EVENT_PREVIEW.getOutputMessage(), date);
        System.out.println(formatted);
        System.out.println();
    }
}
