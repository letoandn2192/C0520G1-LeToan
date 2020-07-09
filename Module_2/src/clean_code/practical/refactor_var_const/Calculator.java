package clean_code.practical.refactor_var_const;

public class Calculator {

    public static final char ADDITION = '+';
    public static final char SUBTRACT = '-';
    public static final char MULTIPLE = '*';
    public static final char DIVISION = '/';

    public static int calculate(int firstOperand, int secondOperand, char operator) {
        switch (operator) {
            case ADDITION:
                return firstOperand + secondOperand;
            case SUBTRACT:
                return firstOperand - secondOperand;
            case MULTIPLE:
                return firstOperand * secondOperand;
            case DIVISION:
                if (secondOperand != 0)
                    return firstOperand / secondOperand;
                else
                    throw new RuntimeException("Can not divide by 0");
            default:
                throw new RuntimeException("Unsupported operation");
        }
    }
}
