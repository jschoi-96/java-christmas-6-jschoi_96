package validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    @DisplayName("입력 값으로 공백이 들어왔을 때 예외 처리 테스트")
    void test_when_input_blank() {
        assertThatThrownBy(() -> InputValidator.validateBlank(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력 값에 공백이 포함될 수 없습니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("입력 값으로 숫자 이외의 값이 들어왔을 때 예외 처리 테스트")
    void test_when_input_not_numbers() {
        assertThatThrownBy(() -> InputValidator.validateNonNumber("NotNumeric"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    private static Stream<String> invalidMenuFormatExamples() {
        return Stream.of(
                "티본스테이크-1,바베큐립-1,",
                "티본스테이크1,바베큐립-1",
                "티본스테이크-1,바베큐립-1 ",
                "티본스테이크-1,,바베큐립-1",
                "티본스테이크-1,"
        );
    }

    @ParameterizedTest
    @DisplayName("메뉴 입력 형식이랑 다를 떄 예외 처리 테스트")
    @MethodSource("invalidMenuFormatExamples")
    void validateMenuFormat(String menuFormat) {
        assertThatThrownBy(() -> InputValidator.validateMenuFormat(menuFormat))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}