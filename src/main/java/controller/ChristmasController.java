package controller;

import christmas.Amount;
import christmas.ChampagneDiscount;
import christmas.ChristmasDiscount;
import christmas.DateDiscount;
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

        OutputView.printChampagnePrize(ChampagneDiscount.containsChampagne(totalPrice.getMoney()));

        discountList(visitDate);
        DateDiscount dailyDiscount = DateDiscount.getDailyDiscount(visitDate);

        OutputView.weekdayDiscount(dailyDiscount.getWeekdayDiscountTotal());
        OutputView.weekendDiscount(dailyDiscount.getWeekendDiscountTotal());
    }

    private void discountList(VisitDate visitDate) {
        OutputView.christmasDiscount(ChristmasDiscount.getChristmasDiscount(visitDate));
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
