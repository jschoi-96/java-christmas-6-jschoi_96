package validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class RangeValidatorTest {

    private Map<String, Integer> menuHashMap;

    @BeforeEach
    void setUp() {
        menuHashMap = new HashMap<>();
    }

    @ParameterizedTest
    @DisplayName("날짜가 1 ~ 31 사이의 값이 아닐 때 예외 처리 테스트")
    @CsvSource({"0" , "32"})
    void validateDateRange(int date) {
        assertThatThrownBy(() -> RangeValidator.validateDateRange(date))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    private static Stream<Integer> invalidMenuCountData() {
        return Stream.of(0, 21, -100, 150);
    }

    @ParameterizedTest
    @DisplayName("메뉴의 개수가 1 ~ 20 사이의 값이 아닐 때 예외 처리 테스트")
    @MethodSource("invalidMenuCountData")
    void validateMenuCountRange(int count) {
        menuHashMap.put("크리스마스파스타", count);
        assertThatThrownBy(() -> RangeValidator.validateMenuCountRange(menuHashMap))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}