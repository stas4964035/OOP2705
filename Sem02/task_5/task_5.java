package Sem02.task_5;

public class task_5 {
    public static void main(String[] args) {
        Shape circle = new Circle();
        circle.commonMethod(); // Вызов метода draw() для Circle

        Shape rectangle = new Rectangle();
        rectangle.commonMethod(); // Вызов метода draw() для Rectangle
    }
}