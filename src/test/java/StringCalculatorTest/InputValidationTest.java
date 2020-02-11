package StringCalculatorTest;

import Controller.InputValidation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidationTest {


    @DisplayName("공백만 입력되었는지 검사")
    @Test
    void validateSpace() {
        assertThatThrownBy(() -> {
            String sourceData = "";
            String[] inputs = sourceData.split(" ");
            InputValidation.validateSpace(inputs);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("식의 처음과 끝이 숫자로 되어있는지 검사")
    @Test
    void validateFirstAndLast() {
        assertThatThrownBy(() -> {
            String sourceData = "3 +";
            String[] inputs = sourceData.split(" ");
            InputValidation.validateFirstAndLast(inputs);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자와 연산자가 번갈아 나오는지 검사")
    @ParameterizedTest
    @ValueSource(strings = {"3 + 4 4 - 5", "3 + + 4"})
    void validateRepeat(String sourceData) {
        assertThatThrownBy(() -> {
            String[] inputs = sourceData.split(" ");
            InputValidation.validateRepeat(inputs);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사칙연산자 이외의 문자가 입력될경우")
    @ParameterizedTest
    @ValueSource(strings = {"3 + 4 # 5", "4 @"})
    void validateOperators(String sourceData) {
        assertThatThrownBy(() -> {
            String[] inputs = sourceData.split(" ");
            InputValidation.validateOperators(inputs);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
