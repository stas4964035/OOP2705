package DZ05.Calc.Validation;

public class CalcOperationValidator extends CalcNullDivideValidator{
    String operationList = "+-*/";
    @Override
    public int validate(double x, double y, char operation){
        if(super.validate(x, y, operation) == 0){
            if(operationList.indexOf(operation) == -1){
                return 2;
            }
            return 0;
        }
        return super.validate(x, y, operation);
    }

}
