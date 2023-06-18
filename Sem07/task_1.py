class Car:
    def __init__(self, model, year):
        self.__make = 42
        self.model = model
        self.year = year

    def start_engine(self):
        print("The engine has started.")

    def getMake(self):
        return self.__make;
my_car = Car("Camry", 2020)
print(my_car.getMake())  # Выводит: Toyota
print(my_car.model)  # Выводит: Camry
print(my_car.year)  # Выводит: 2020
my_car.start_engine()  # Выводит: The engine has started.