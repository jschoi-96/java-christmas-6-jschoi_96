package enums;

public enum OutputMessage {

    HELLO_MESSAGE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    ASK_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!) "),
    ASK_MENU_AND_COUNT("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    EVENT_PREVIEW("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    MENU_LIST("<주문 메뉴>"),
    PRICE_BEFORE_SALE("<할인 전 총주문 금액>"),
    GIFT_MENU ("<증정 메뉴>"),
    PRIVILEGE_HISTORY("<혜택 내역>"),
    TOTAL_PRIVILEGE_PRICE("<총혜택 금액>"),
    PRICE_AFTER_SALE("<할인 후 예상 결제 금액>"),
    DECEMBER_EVENT_BADGE("<12월 이벤트 배지>"),
    NONE("없음"),
    NONE_DISCOUNT("0원")
    ;
    private final String outputMessage;

    OutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }
    public String getOutputMessage() {
        return outputMessage;
    }
}
