<<<<<<< HEAD
package Controller;

import View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    private List<Integer> numbers = new ArrayList<>();
    private List<Operator> operators = new ArrayList<>();

    public void run() {
        initializeInputs();
        OutputView.printOutputMessage(calculate());
    }

    /**
     * 입력값 예외처리 후 숫자와 연산자를 분리
     */
    public void initializeInputs() {
        String[] inputs = InputValidation.getValidatedInput();
        for (String val : inputs) {
            try {
                numbers.add(Integer.parseInt(val));
            } catch (Exception e) {
                operators.add(OperatorMap.getOperatorByString(val));
            }
        }
    }

    public double calculate() {
        double result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            result = operators.get(i).compute(result, numbers.get(i+1));
        }
        return result;
    }
}
=======
package Controller;

import View.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringCalculator {
    private static List<Integer> numbers = new ArrayList<>();
    private static List<Operator> operators = new ArrayList<>();
    private static Map<String, Operator> operatorMap = new HashMap<String, Operator>() {
        {
            put("+", Operator.PLUS);
            put("-", Operator.MINUS);
            put("*", Operator.MULTIPLY);
            put("/", Operator.DIVIDE);
        }
    };

    public static Operator getOperatorByString(String val) {
        return operatorMap.get(val);
    }

    public static void run() {
        initializeInputs();
        OutputView.printOutputMessage(calculate());
    }

    /**
     * 입력값 예외처리 후 숫자와 연산자를 분리
     */
    public static void initializeInputs() {
        String[] inputs = InputValidation.getValidatedInput();
        for (String val : inputs) {
            try {
                numbers.add(Integer.parseInt(val));
            } catch (Exception e) {
                operators.add(getOperatorByString(val));
            }
        }
    }

    public static double calculate() {
        double result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            result = operators.get(i).compute(result, numbers.get(i + 1));
        }
        return result;
    }
}
>>>>>>> 4dba8222c7c808b69395a3ea29a61058edc82916
