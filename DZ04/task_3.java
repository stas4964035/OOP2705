package DZ04;

import java.util.Comparator;

public class task_3 {
    public static void main(String[] args) {
        System.out.println(getMax(42, 10));
        System.out.println(getMax(4.2, 1.0));
        System.out.println(getMax("first", "second"));

    }
    public static <T extends Comparable<T>>T getMax(T a, T b){
        return a.compareTo(b) >= 0 ? a : b;
    }
}
