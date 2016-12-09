package Chapter3.chapter3_6;

import java.util.LinkedList;

class Animal {
    private String name;
    private int order;

    public Animal (String name) {
        this.name = name;
    }

    public void setOrder (int order) {
        this.order = order;
    }

    public int getOrder () {
        return this.order;
    }
}

class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }
}

public class chapter3_6 {
    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();
    int order = 0;

    public void enqueue (Animal animal) {
        animal.setOrder(order++);

        if (animal instanceof Dog) {
            dogs.add((Dog) animal);
        } else if (animal instanceof Cat) {
            cats.add((Cat) animal);
        }
    }

    public Animal dequeueAny () {
        if (dogs.size() == 0 && cats.size() == 0) {
            return null;
        }

        if (dogs.size() == 0) {
            return dequeueCat();
        }

        if (cats.size() == 0) {
            return dequeueDog();
        }

        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if (dog.getOrder() <= cat.getOrder()) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }
    }

    public Dog dequeueDog () {
        return dogs.poll();
    }

    public Cat dequeueCat () {
        return cats.poll();
    }
}
