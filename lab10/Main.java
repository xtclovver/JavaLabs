class Animal {
    String food;
    String location;

    void makeNoise() {
        System.out.println("Животное спит");
    }

    void eat() {
        System.out.println("Животное ест");
    }

    void sleep() {
        System.out.println("Животное спит");
    }
}

class Dog extends Animal {
    Dog (String breed, String food, String location)
    {
        this.breed = breed;
        this.food = food;
        this.location = location;
    }
    String breed;

    @Override
    void makeNoise() {
        System.out.println("Собака лает");
    }

    @Override
    void eat() {
        System.out.println("Собака кушает кость");
    }
}

class Cat extends Animal {
    String color;

    Cat (String color, String food, String location)
    {
        this.color = color;
        this.food = food;
        this.location = location;
    }

    @Override
    void makeNoise() {
        System.out.println("Кошка мурлычет");
    }

    @Override
    void eat() {
        System.out.println("Кошка ест рыбу");
    }
}

class Horse extends Animal {
    String breed;

    Horse (String breed, String food, String location)
    {
        this.breed = breed;
        this.food = food;
        this.location = location;
    }
    @Override
    void makeNoise() {
        System.out.println("Лошадь фыркает");
    }

    @Override
    void eat() {
        System.out.println("Лошадь пасется на лугу");
    }
}

class Vet {
    static void treatAnimal(Animal animal) {
        System.out.println("Еда: " + animal.food);
        System.out.println("Местоположение: " + animal.location);
    }
}

public class Main {
    public static void main(String[] args) {
        Dog Dobby = new Dog("Доберман", "Мясо", "Первый этаж дома");
        Cat Nikol = new Cat("Черный", "Курица", "Второй этаж дома");
        Cat Vitalij = new Cat("Оранжевый", "Сено", "В загоне");
        Dobby.makeNoise();
        Nikol.eat();
        Vitalij.sleep();
        Vet.treatAnimal(Dobby);

    }
}