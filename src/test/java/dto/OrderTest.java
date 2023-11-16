package dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    private Order order;
    private Map<String, Integer> menuMap = new HashMap<>();

    @BeforeEach
    void setUp() {
        String input = "타파스-1,제로콜라-1";
        menuMap.put("타파스", 1);
        menuMap.put("제로콜라", 1);
        order = new Order(input, menuMap);
    }

    @Test
    @DisplayName("주문 받은 메뉴가 올바르게 출력되는지 테스트")
    void test_order_print_correct() {
        String expectedString = "타파스 1개\n제로콜라 1개\n";
        assertEquals(order.toString(), expectedString);
    }

    @Test
    @DisplayName("주문 받은 메뉴를 올바르게 Map에 저장하는지 테스트")
    void test_save_input_to_map() {
        Map<String, Integer> expectedOrder = Map.of("타파스", 1, "제로콜라", 1);
        Map<String, Integer> actualOrder = order.getOrder();
        assertEquals(expectedOrder, actualOrder);
    }
}