package controller;

import christmas.Amount;
import dto.Order;
import dto.VisitDate;
import utils.Parser;
import utils.RepeatInput;
import view.InputView;
import view.OutputView;

public class ChristmasController {

    public void eventPlanner() {
        OutputView.printHelloMessage();
        VisitDate visitDate = RepeatInput.repeatWhenInvalid(this::dateValidate);

        OutputView.printMenuAndCount();
        Order order = RepeatInput.repeatWhenInvalid(this::menuAndCountValidate);

        OutputView.printEventPreview(visitDate);
        OutputView.printUserMenu(order);

        Amount totalPrice = Amount.totalPriceBeforeSale(order.getOrder());
        OutputView.printEventList(totalPrice.getMoney());
        OutputView.printChampagnePrize(Amount.containsChampagne(totalPrice.getMoney()));
    }

    private VisitDate dateValidate(){
        String input = InputView.readDate();
        return new VisitDate(input);
    }

    private Order menuAndCountValidate() {
        String input = InputView.readMenuAndCount();
        return new Order(input,  Parser.convertToMenuHashMap(input));
    }
}
