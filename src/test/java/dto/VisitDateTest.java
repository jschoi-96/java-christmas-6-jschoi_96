package dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VisitDateTest {

    @Test
    @DisplayName("입력값이 올바르게 int 타입의 방문날짜로 변환되는지 테스트")
    void test_when_input_convert_to_date() {
        int expectedDate = 14;
        VisitDate visitDate = new VisitDate("14");
        int actualDate = visitDate.getVisitDate();
        assertEquals(expectedDate, actualDate);
    }

}