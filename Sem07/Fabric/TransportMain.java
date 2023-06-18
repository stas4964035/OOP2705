package Sem07.Fabric;

// Абстрактный класс транспортного средства
abstract class Transport {
    public abstract void drive();
}

// Конкретный класс автомобиля
class Car extends Transport {
    @Override
    public void drive() {
        System.out.println("Driving a car");
    }
}

// Конкретный класс велосипеда
class Bike extends Transport {
    @Override
    public void drive() {
        System.out.println("Riding a bike");
    }
}

// Абстрактная фабрика
abstract class TransportFactory {
    public abstract Transport createTransport();
}

// Фабрика для создания автомобилей
class CarFactory extends TransportFactory {
    @Override
    public Transport createTransport() {
        return new Car();
    }
}

// Фабрика для создания велосипедов
class BikeFactory extends TransportFactory {
    @Override
    public Transport createTransport() {
        return new Bike();
    }
}

// Клиентский код
public class TransportMain {
    public static void main(String[] args) {
        TransportFactory factory = new CarFactory();
        Transport transport = factory.createTransport();
        transport.drive(); // Driving a car

        factory = new BikeFactory();
        transport = factory.createTransport();
        transport.drive(); // Riding a bike
    }
}