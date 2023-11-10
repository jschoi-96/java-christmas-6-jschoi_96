package controller;

import view.InputView;
import view.OutputView;

public class ChristmasController {

    public void eventPlanner() {
        reservationDate();
    }

    private void reservationDate() {
        OutputView.printHelloMessage();
        InputView.readDate();
    }
}
