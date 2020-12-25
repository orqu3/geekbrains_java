package ru.geekbrains.java.javathree.lesson_1.fruits_and_boxes;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    private final List<T> box;

    public Box() {
        this.box = new ArrayList<>();
    }

    public void addFruit(T fruit) {
        this.box.add(fruit);
    }

    private void clearBox() {
        this.box.clear();
    }

    public float getWeight() {
        float totalBoxWeight = 0.0f;
        for (T t : this.box) {
            totalBoxWeight = totalBoxWeight + t.getWeight();
        }
        return totalBoxWeight;
    }

    public boolean compare(Box<? extends Fruit> box) {
        return Math.abs(getWeight() - box.getWeight()) < 0.0001f;
    }

    public void replaceFruitToAnotherBox(Box<? super T> anotherBox) {
        anotherBox.box.addAll(this.box);
        clearBox();
    }
}
