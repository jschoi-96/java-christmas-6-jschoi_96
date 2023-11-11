package controller;

import dto.VisitDate;
import utils.RepeatInput;
import view.InputView;
import view.OutputView;

public class ChristmasController {

    public void eventPlanner() {
        reservationDate();
    }

    private void reservationDate() {
        OutputView.printHelloMessage();
        int date = RepeatInput.repeatWhenInvalid(this::dateValidate);
    }

    private int dateValidate(){
        String input = InputView.readDate();
        VisitDate visitDate = new VisitDate(input);
        return visitDate.getVisitDate();
    }
}
