public class Calculator {
    public static float calculate(String operator, float firstOperand, float secondOperand) throws Exception {
        float result = 0;
        switch (operator) {
            case "Add":
                result = firstOperand + secondOperand;
                break;
            case "Subtract":
                result = firstOperand - secondOperand;
                break;
            case "Multiple":
                result = firstOperand * secondOperand;
                break;
            case "Divide":
                if(secondOperand != 0) {
                    result = firstOperand / secondOperand;
                } else {
                    throw new Exception("Divide By 0");
                }
                break;
            default:
                throw new Exception("Invalid Operator");
        }
        return result;
    }
}
