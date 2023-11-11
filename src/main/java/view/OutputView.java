package view;

import enums.OutputMessage;

public class OutputView {

    public static void printHelloMessage() {
        System.out.println(OutputMessage.HELLO_MESSAGE.getOutputMessage());
        System.out.println(OutputMessage.ASK_DATE.getOutputMessage());
    }
}
