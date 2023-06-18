package Sem07.Adapter;

// Интерфейс, который необходимо адаптировать
interface Target {
    void request();
}

// Адаптируемый класс
class Adaptee {
    public void specificRequest() {
        System.out.println("Выполнение специфического запроса.");
    }
}

// Адаптер
class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public void request() {
        adaptee.specificRequest();
    }
}

// Пример использования
public class Main {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target adapter = new Adapter(adaptee);

        adapter.request();
    }
}