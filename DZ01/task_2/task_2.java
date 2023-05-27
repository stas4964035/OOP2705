package DZ01.task_2;

/*
* Задача 2:
Реализуйте класс "Прямоугольник" (Rectangle), который имеет свойства ширина (width) и высота (height). Класс должен обладать следующими методами:

Конструктор без параметров, который создает прямоугольник с шириной и высотой по умолчанию.
Конструктор, который принимает значения ширины и высоты и создает прямоугольник с заданными значениями.
Методы доступа (геттеры и сеттеры) для свойств ширины и высоты.
Метод "вычислить площадь" (calculateArea), который возвращает площадь прямоугольника (ширина * высота).
Метод "вычислить периметр" (calculatePerimeter), который возвращает периметр прямоугольника (2 * (ширина + высота)).*/
public class task_2 {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(4);
        Rectangle r3 = new Rectangle(5, 6);

        r1.calculateArea();
        r1.calculatePerimeter();
        r2.calculateArea();
        r2.calculatePerimeter();
        r3.calculateArea();
        r3.calculatePerimeter();

        Rectangle.calculateArea(10, 10);
        Rectangle.calculatePerimeter(20, 20);
    }
}
