package StringCalculatorTest;

import Controller.Operator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    private List<Integer> numbers = new ArrayList<>();
    private List<Operator> operators = new ArrayList<>();
    private static Map<String, Operator> operatorMap = new HashMap<String, Operator>(){
        {
            put("+", Operator.PLUS);
            put("-", Operator.MINUS);
            put("*", Operator.MULTIPLY);
            put("/", Operator.DIVIDE);
        }
    };

    private static Operator getOperatorByString(String val){
        return operatorMap.get(val);
    }

    @BeforeEach
    void setUp(){
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        operators.add(getOperatorByString("+"));
        operators.add(getOperatorByString("-"));
        operators.add(getOperatorByString("*"));
    }

    @DisplayName("문자열 식 계산")
    @Test
    void calculate() {
        double result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++){
            result = operators.get(i).compute(result, numbers.get(i+1));
        }
        assertThat(result).isEqualTo(0);
    }
}
