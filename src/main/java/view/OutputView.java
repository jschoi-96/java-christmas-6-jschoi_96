package view;

import eums.OutputMessage;

public class OutputView {

    public static void printHelloMessage() {
        System.out.println(OutputMessage.HELLO_MESSAGE.getMessage());
        System.out.println(OutputMessage.ASK_DATE.getMessage());
    }
}
