package DZ04;

public class task_1 {
    public static void main(String[] args) {
        printElement("fourthy two");
        printElement(42);
        printElement(42.0);
        printElement(42f);
    }
    static <T> void printElement(T t){
        System.out.println(t.toString() + ": " + t.getClass().getName());
    }
}
