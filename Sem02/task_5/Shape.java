package Sem02.task_5;

abstract class Shape {
    abstract void draw();

    void commonMethod() {
        draw();
        // Общая реализация метода
    }
}