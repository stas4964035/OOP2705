package DZ05.Calc;

public class CalcPresenter {
    private CalcModel model = new CalcModel();
    private CalcView view = new CalcView();

    public void startCalc(){

        while (model.validate() != 0){
            if(model.validation == 1) view.printData("Ошибка деления на 0!");
            if(model.validation == 2) view.printData("Введен некоректный оператор!");
            model.setX(view.inputValue("Enter a:"));
            model.setOperation(view.inputOperation("Enter operation:"));
            model.setY(view.inputValue("Enter b:"));
        }
        model.goCalc();
        view.printData("Result: ", model.getResult());
    }
}
