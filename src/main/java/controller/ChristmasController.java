package controller;

import christmas.*;
import dto.Order;
import dto.VisitDate;
import enums.Numbers;
import enums.core.Badge;
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

        int totalBenefitPrice = Amount.finalPriceAfterSale(visitDate, amount.getMoney());
        OutputView.totalSalePrice(totalBenefitPrice);

        // 여기서 증정품이 계산될 경우 제외해야한다,
        OutputView.totalPriceAfterSale(Amount.totalPaymentWithoutChampagne(visitDate, amount.getMoney()));

        OutputView.decemberEventBadge(Badge.whichBadge(totalBenefitPrice));
    }

    private void discountList(VisitDate visitDate) {
        if (amount.getMoney() >= Numbers.MINIMUM_SALE_STANDARD.getNumbers()) {
            OutputView.christmasDiscount(ChristmasDiscount.getChristmasDiscount(visitDate));
            DateDiscount dailyDiscount = DateDiscount.getDailyDiscount(visitDate);
            OutputView.weekdayDiscount(dailyDiscount.getWeekdayDiscountTotal());
            OutputView.weekendDiscount(dailyDiscount.getWeekendDiscountTotal());
            OutputView.specialDiscount(Badge.meetBadgeStandard(visitDate, amount.getMoney()));
            OutputView.privilegeDiscount(ChampagneDiscount.champagnePrice(amount.getMoney()));
            return;
        }
        OutputView.belowPrivilegeStandard(amount.getMoney());
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
