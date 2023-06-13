package DZ05.Calc.Validation;

public class CalcNullDivideValidator {

    public int validate(double x, double y, char operation){
        if (operation == '/' && (x == 0 || y == 0)) {
            return 1;
        }
        return 0;
    }
}
