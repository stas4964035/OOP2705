package DZ05.Calc;

import java.util.Scanner;

public class CalcView {
    Scanner scan = new Scanner(System.in);
    public double inputValue(String title){
        System.out.println(title);
        return Double.parseDouble(scan.nextLine());
    }
    public char inputOperation(String title){
        System.out.println(title);
        return scan.nextLine().charAt(0);
    }
    public void printData(String data) {
        System.out.println(data);
    }
    public void printData(String title, double v){
        System.out.printf("%s: %f", title, v);
    }
}
