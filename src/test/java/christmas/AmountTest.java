package christmas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AmountTest {

    private Amount amount;

    @Test
    @DisplayName("올바른 메뉴와 그에 맞는 개수의 가격을 리턴하는지 테스트")
    void test_correct_menu_and_count_price() {
        int steak = Amount.calculateUserMenuAndPrice("티본스테이크", 2);
        assertEquals(110000, steak);
        int tapas = Amount.calculateUserMenuAndPrice("타파스", 3);
        assertEquals(16500, tapas);
    }

    @Test
    @DisplayName("메뉴에 없는 음식을 입력값으로 받았을 때, 가격이 0을 반환하는지 테스트")
    void test_when_invalid_menu(){
        int steak = Amount.calculateUserMenuAndPrice("양갈비스테이크", 2);
        assertEquals(0, steak);
    }


    @Test
    @DisplayName("여러 메뉴와 수량을 입력값으로 받을 때 올바르게 가격을 리턴하는지 테스트")
    void test_multiple_correct_menu_and_count_price() {
        Map<String, Integer> menuMap = new HashMap<>();
        menuMap.put("티본스테이크", 1);
        menuMap.put("바비큐립", 1);
        menuMap.put("초코케이크", 2);
        menuMap.put("제로콜라", 1);
        Amount totalPrice = Amount.totalPriceBeforeSale(menuMap);
        assertEquals(142000, totalPrice.getMoney());

    }

}