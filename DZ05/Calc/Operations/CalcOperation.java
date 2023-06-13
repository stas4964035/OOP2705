package DZ05.Calc.Operations;

import DZ05.Calc.CalcModel;

public class CalcOperation implements MultDiv, PlusMinus{
    public double goOperation(double x, double y, char operation){
        switch (operation) {
            case '+' -> {
                return sum(x, y);
            }
            case '-' -> {
                return sub(x, y);
            }
            case '*' -> {
                return multiply(x, y);
            }
            case '/' -> {
                return divide(x, y);
            }
            default -> {
                return 0;
            }
        }
    }


    public double multiply(double a, double b) {
        return a * b;
    }


    public double divide(double a, double b) {
        return a / b;
    }


    public double sum(double a, double b) {
        return a + b;
    }


    public double sub(double a, double b) {
        return a - b;
    }
}
