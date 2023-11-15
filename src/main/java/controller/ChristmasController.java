package controller;

import christmas.*;
import dto.Order;
import dto.TotalDiscountDto;
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
        TotalAmount amount = TotalAmount.totalPriceBeforeSale(order.getOrder());

        userMenu(visitDate, order);
        totalPriceAndGift(order);
        discountHistory(visitDate, amount);
    }

    private void userMenu(VisitDate visitDate, Order order) {
        OutputView.printEventPreview(visitDate);
        OutputView.printUserMenu(order);
    }
    private void totalPriceAndGift(Order order) {
        TotalAmount amount = TotalAmount.totalPriceBeforeSale(order.getOrder());
        int totalPrice = amount.getMoney();
        OutputView.printTotalPriceAndGift(totalPrice);
    }
    private void discountHistory(VisitDate visitDate, TotalAmount amount) {
        DateDiscount dateDiscount = DateDiscount.getDailyDiscount(visitDate);
        ChristmasDiscount christmasDiscount = ChristmasDiscount.totalChristmasDiscount(visitDate);
        ChampagneDiscount champagneDiscount = new ChampagneDiscount(amount.getMoney());
        TotalDiscountDto totalDiscountDto = new TotalDiscountDto(dateDiscount, christmasDiscount, champagneDiscount);
        OutputView.printDiscountHistory(totalDiscountDto, amount.getMoney());
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
