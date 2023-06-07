package DZ04;

import java.lang.reflect.Array;

public class task_2 {
    public static void main(String[] args) {
        String[] strArr = {"string", "array", "some"};
        Integer[] intArr = {0, 42, 12, 3, 5};
        printArray(strArr);
        printArray(intArr);
    }
    static <T> void printArray(T[] arr){
        for (T el: arr) {
            System.out.println(el.toString() + ": " + el.getClass().getName());
        }
    }
}
