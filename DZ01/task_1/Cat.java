package DZ01.task_1;

public class Cat {
    private String name;
    private int age;
    private Owner master;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Cat(String name, int age, Owner master) {
        this(name, age);
        this.master = master;
    }

    public Cat() {
        this("Котенок", 0);
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        if (age == 0 || age > 4) {
            return age + " лет";
        } else if (age == 1) {
            return age + " год";
        } else {
            return age + " года";
        }
    }

    public Owner getMaster() {
        return master;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMaster(Owner master) {
        this.master = master;
    }

    public void greet() {
        try {
            System.out.printf("Мяу! Меня зовут %s. Мне %s. Мой владелец - %s.\n", name, getAge(), master.getName());
        } catch (NullPointerException ex) {
            System.out.printf("Мяу! Меня зовут %s. Мне %s.\n", name, getAge());
        }

    }
}
