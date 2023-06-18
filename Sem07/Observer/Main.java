package Sem07.Observer;

import java.util.ArrayList;
import java.util.List;

// Интерфейс наблюдателя
interface Observer {
    void update();
}

// Наблюдаемый объект
class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public void doSomething() {
        // Выполнение действия
        // ...

        // Уведомление наблюдатов об изменении состояния
        notifyObservers();
    }
}

// Наблюдатель
class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    public void update() {
        System.out.println(name + " получил уведомление об изменении состояния");
    }
}

// Пример использования
public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();

        Observer observer1 = new ConcreteObserver("Наблюдатель 1");
        Observer observer2 = new ConcreteObserver("Наблюдатель 2");

        subject.addObserver(observer1);
        subject.addObserver(observer2);

        subject.doSomething();

        subject.removeObserver(observer2);

        subject.doSomething();
    }
}