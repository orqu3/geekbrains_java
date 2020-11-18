package ru.geekbrains.java.javaone.lesson_7;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void info() {
        System.out.println("Plate has " + food + " food");
    }

    public void decreaseFood(int amount) {
        this.food -= amount;
    }

    public void increaseFood(int amount) {
        this.food += amount;
    }
}
