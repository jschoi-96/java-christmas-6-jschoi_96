package controller;

import christmas.*;
import dto.Order;
import dto.VisitDate;
import utils.Parser;
import utils.RepeatInput;
import view.InputView;
import view.OutputView;

public class ChristmasController {

    private Amount amount;

    public void eventPlanner() {
        OutputView.printHelloMessage();
        VisitDate visitDate = RepeatInput.repeatWhenInvalid(this::dateValidate);

        OutputView.printMenuAndCount();
        Order order = RepeatInput.repeatWhenInvalid(this::menuAndCountValidate);

        OutputView.printEventPreview(visitDate);
        OutputView.printUserMenu(order);

        amount = Amount.totalPriceBeforeSale(order.getOrder());
        OutputView.printEventList(amount.getMoney());

        OutputView.printChampagnePrize(ChampagneDiscount.containsChampagne(amount.getMoney()));

        discountList(visitDate);

    }

    private void discountList(VisitDate visitDate) {
        OutputView.christmasDiscount(ChristmasDiscount.getChristmasDiscount(visitDate));
        DateDiscount dailyDiscount = DateDiscount.getDailyDiscount(visitDate);
        OutputView.weekdayDiscount(dailyDiscount.getWeekdayDiscountTotal());
        OutputView.weekendDiscount(dailyDiscount.getWeekendDiscountTotal());
        OutputView.specialDiscount(Badge.meetBadgeStandard(visitDate, amount.getMoney()));
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
