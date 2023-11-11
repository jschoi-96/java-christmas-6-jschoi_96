package enums;

public enum ErrorMessage {
    BLANK_INPUT("[ERROR] 입력 값에 공백이 포함될 수 없습니다. 다시 입력해 주세요."),
    INVALID_NUMBER_FORMAT("[ERROR] 입력 값에 숫자 이외의 값이 포함될 수 없습니다.다시 입력해 주세요."),
    INVALID_DATE_RANGE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_MENU("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_MENU_COUNT_RANGE("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_MENU_FORMAT("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    DUPLICATE_MENU("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
    ;

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
