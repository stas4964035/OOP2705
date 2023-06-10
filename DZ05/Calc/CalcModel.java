package DZ05.Calc;

public class CalcModel {
    private double x, y;
    private char operation;
    private double result;
    int validation;


    public void goCalc(){
        switch (operation) {
            case '+' -> result = x + y;
            case '-' -> result = x - y;
            case '*' -> result = x * y;
            case '/' -> result = x / y;
        }
    }
    public int validate(){
        if (operation == '/' && (x == 0 || y == 0)) {
            return validation = 1;
        }else if("+-*/".indexOf(operation) == -1){
            return validation = 2;
        }
        return 0;
    }

    public double getResult() {
        return result;
    }

    public void setOperation(char operation) {
        this.operation = operation;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
