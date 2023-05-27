package DZ01.task_2;

public class Rectangle {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(int width) {
        this(width, width);
    }

    public Rectangle() {
        this(5, 5);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void calculateArea() {
        System.out.printf("Площадь прямоугольника %dх%d: %d\n", width, height, width * height);
    }

    public void calculatePerimeter() {
        System.out.printf("Периметр прямоугольника %dх%d: %d\n", width, height, 2 * (width + height));
    }

    public static void calculateArea(int width, int height) {
        System.out.printf("Площадь прямоугольника %dх%d: %d\n", width, height, width * height);
    }

    public static void calculatePerimeter(int width, int height) {
        System.out.printf("Периметр прямоугольника %dх%d: %d\n", width, height, 2 * (width + height));
    }
}
