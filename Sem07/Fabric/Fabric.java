package Sem07.Fabric;
//
//// Абстрактный класс продукта
//abstract class Product {
//    public abstract void doSomething();
//}
//
//// Конкретный класс продукта A
//class ConcreteProductA extends Product {
//    public void doSomething() {
//        System.out.println("Выполнение операции в конкретном продукте A.");
//    }
//}
//
//// Конкретный класс продукта B
//class ConcreteProductB extends Product {
//    public void doSomething() {
//        System.out.println("Выполнение операции в конкретном продукте B.");
//    }
//}
//
//// Абстрактный класс создателя
//abstract class Creator {
//    public abstract Product createProduct();
//
//    public void doSomethingWithProduct() {
//        Product product = createProduct();
//        product.doSomething();
//    }
//}
//
//// Конкретный класс создателя A
//class ConcreteCreatorA extends Creator {
//    public Product createProduct() {
//        return new ConcreteProductA();
//    }
//}
//
//// Конкретный класс создателя B
//class ConcreteCreatorB extends Creator {
//    public Product createProduct() {
//        return new ConcreteProductB();
//    }
//}
//
//// Пример использования
//public class Fabric {
//    public static void main(String[] args) {
//        Creator creatorA = new ConcreteCreatorA();
//        creatorA.doSomethingWithProduct();
//
//        System.out.println();
//
//        Creator creatorB = new ConcreteCreatorB();
//        creatorB.doSomethingWithProduct();
//    }
//}


abstract class Product {
    public abstract void doSomething();
}

class ConcreteProductA extends Product {
    @Override
    public void doSomething() {
        System.out.println("Doing something in ConcreteProductA");
    }
}

class ExtendedConcreteProductA extends ConcreteProductA {
    @Override
    public void doSomething() {
        super.doSomething();
        System.out.println("Adding additional functionality in ExtendedConcreteProductA");
    }

    public void additionalMethod() {
        System.out.println("Additional method in ExtendedConcreteProductA");
    }
}

class Factory {
    public Product createProduct() {
        return new ConcreteProductA();
    }
}

class ExtendedFactory extends Factory {
    @Override
    public Product createProduct() {
        return new ExtendedConcreteProductA();
    }
}

public class Fabric {
    public static void main(String[] args) {
        Factory factory = new ExtendedFactory();
        Product product = factory.createProduct();
        product.doSomething(); // Output: Doing something in ConcreteProductA
        //         Adding additional functionality in ExtendedConcreteProductA

        if (product instanceof ExtendedConcreteProductA) {
            ExtendedConcreteProductA extendedProduct = (ExtendedConcreteProductA) product;
            extendedProduct.additionalMethod(); // Output: Additional method in ExtendedConcreteProductA
        }
    }
}