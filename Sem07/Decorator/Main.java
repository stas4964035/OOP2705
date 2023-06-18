package Sem07.Decorator;
// Интерфейс компонента
interface Component {
    void operation();
}

// Конкретный компонент
class ConcreteComponent implements Component {
    public void operation() {
        System.out.println("Выполнение операции в конкретном компоненте.");
    }
}

// Абстрактный класс декоратора
abstract class Decorator implements Component {
    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    public void operation() {
        component.operation();
    }
}

// Конкретные декораторы
class ConcreteDecoratorA extends Decorator {
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    public void operation() {
        super.operation();
        additionalOperationA();
    }

    private void additionalOperationA() {
        System.out.println("Выполнение дополнительной операции A.");
    }
}

class ConcreteDecoratorB extends Decorator {
    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    public void operation() {
        super.operation();
        additionalOperationB();
    }

    private void additionalOperationB() {
        System.out.println("Выполнение дополнительной операции B.");
    }
}

// Пример использования
public class Main {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        component.operation();

        System.out.println();

        Component decoratedComponentA = new ConcreteDecoratorA(component);
        decoratedComponentA.operation();

        System.out.println();

        Component decoratedComponentB = new ConcreteDecoratorB(decoratedComponentA);
        decoratedComponentB.operation();
    }
}