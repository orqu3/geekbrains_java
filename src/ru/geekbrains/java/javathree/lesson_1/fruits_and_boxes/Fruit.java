package ru.geekbrains.java.javathree.lesson_1.fruits_and_boxes;

public abstract class Fruit {

    private final float weight;

    public Fruit(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }
}
