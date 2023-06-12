package DZ05.User;

import java.util.Scanner;

public class UserView {
    Scanner scanner = new Scanner(System.in);
    public String input(String title){
        System.out.println(title);
        return scanner.nextLine();
    }
    public int menuSelector(String title){
        System.out.println(title);
        return Integer.parseInt(scanner.nextLine());
    }
    public void print(String title, String data){
        System.out.println(title);
        System.out.println(data);
    }
    public void print(String data){
        System.out.println(data);
    }
}
