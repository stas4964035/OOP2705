package DZ05.Calc;

import DZ05.Calc.Operations.CalcOperation;
import DZ05.Calc.Validation.CalcOperationValidator;

public class CalcModel<T extends Number> {
    private T x, y;
    private char operation;
    private double result;
    int validation = 10;
    CalcOperationValidator validator = new CalcOperationValidator();
    CalcOperation calcOperation = new CalcOperation();


    public void goCalc(){
        validation = validator.validate(this.getX(), this.getY(), this.operation);
        if(validation == 0) {
            result = calcOperation.goOperation(this.getX(), this.getY(), this.operation);
        }

    }


    public double getResult() {
        return result;
    }

    public void setOperation(char operation) {
        this.operation = operation;
    }


    public void setX(T x) {
        this.x = x;
    }

    public void setY(T y) {
        this.y = y;
    }

    public double getX() {
        return x.doubleValue();
    }

    public double getY() {
        return y.doubleValue();
    }
}
