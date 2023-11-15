package controller;

import christmas.*;
import dto.Order;
import dto.TotalDiscountDto;
import dto.VisitDate;
import enums.core.Badge;
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

        // <할인 전 총주문 금액>
        Amount amount = Amount.totalPriceBeforeSale(order.getOrder());
        OutputView.printEventList(amount.getMoney());

        // 증정 메뉴
        OutputView.printChampagnePrize(amount.getMoney());
        discountList(visitDate, amount);
    }

    private void discountList(VisitDate visitDate, Amount amount) {
        DateDiscount dateDiscount = DateDiscount.getDailyDiscount(visitDate);
        ChristmasDiscount christmasDiscount = ChristmasDiscount.totalChristmasDiscount(visitDate);
        ChampagneDiscount champagneDiscount = new ChampagneDiscount(amount.getMoney());
        TotalDiscountDto totalDiscountDto = new TotalDiscountDto(dateDiscount, christmasDiscount, champagneDiscount);
        OutputView.discountHistory(totalDiscountDto, amount.getMoney());
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
