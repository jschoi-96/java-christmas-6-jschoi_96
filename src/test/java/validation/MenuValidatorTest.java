package validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class MenuValidatorTest {

    private Map<String, Integer> menuHashMap;

    @BeforeEach
    void setUp() {
        menuHashMap = new HashMap<>();
    }

    @Test
    @DisplayName("메뉴판에 없는 메뉴를 입력 받았을 때 예외 처리 테스트")
    @ValueSource(strings = {"라면,3"})
    void test_when_input_non_menu() {
        menuHashMap.put("라면", 3);
        assertThatThrownBy(() -> MenuValidator.validateNonMenu(menuHashMap))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("중복된 메뉴를 입력값으로 받을 때 예외 처리 테스트")
    void test_when_duplicate_menu() {
        menuHashMap.put("해산물파스타", 3);
        assertThatThrownBy(() -> MenuValidator.validateDuplicateMenu(menuHashMap, "해산물파스타"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("음료만 단독으로 입력값으로 받을 때 예외 처리 테스트")
    void test_when_input_only_drink() {
        menuHashMap.put("레드와인", 1);
        assertThatThrownBy(() -> MenuValidator.validateOnlyDrink(menuHashMap))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 음료만 단독으로 주문할 수 없습니다. 다시 입력해 주세요");
    }

    @ParameterizedTest
    @DisplayName("음료 외에 다른 음식을 단독으로 주문할 때 통과되는지 테스트")
    @CsvSource({"양송이수프, 3" , "티본스테이크, 2" , "초코케이크, 1"})
    void test_when_input_only_not_drink(String menuName, int count) {
        menuHashMap.put(menuName, count);
        assertThatCode(() -> MenuValidator.validateOnlyDrink(menuHashMap))
                .doesNotThrowAnyException();
    }
}