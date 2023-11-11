package controller;

import dto.Order;
import dto.VisitDate;
import utils.Parser;
import utils.RepeatInput;
import view.InputView;
import view.OutputView;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ChristmasController {

    public void eventPlanner() {
        reservationDate();
        getMenuAndCount();
    }

    private void reservationDate() {
        OutputView.printHelloMessage();
        int date = RepeatInput.repeatWhenInvalid(this::dateValidate);
    }

    private void getMenuAndCount(){
        OutputView.printMenuAndCount();
        Order order = RepeatInput.repeatWhenInvalid(this::menuAndCountValidate);

    }

    private int dateValidate(){
        String input = InputView.readDate();
        VisitDate visitDate = new VisitDate(input);
        return visitDate.getVisitDate();
    }

    private Order menuAndCountValidate() {
        String input = InputView.readMenuAndCount();
        Order order = new Order(input, new LinkedHashMap<>());
        return order;
    }
}
