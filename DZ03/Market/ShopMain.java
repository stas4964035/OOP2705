package DZ03.Market;

public class ShopMain {
    public static void main(String[] args) {
        Food f1 = new Food("Pizza", 800, "01.06.2023", 2);
        Food f2 = new Food("Bread", 100, "05.06.2023", 2);
        System.out.println(f1.toString());
        System.out.println(f2.toString());
    }
}
