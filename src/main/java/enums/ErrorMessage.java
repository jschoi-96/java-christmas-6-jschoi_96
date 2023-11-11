package enums;

public enum ErrorMessage {
    BLANK_INPUT("[ERROR] 입력 값에 공백이 포함될 수 없습니다."),
    INVALID_NUMBER_FORMAT("[ERROR] 입력 값에 숫자 이외의 값이 포함될 수 없습니다."),
    INVALID_RANGE("[ERROR] 방문 날짜는 1 부터 31 사이의 숫자여야 합니다."),
    ;

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
