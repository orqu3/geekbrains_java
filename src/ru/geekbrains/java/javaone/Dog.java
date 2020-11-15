package ru.geekbrains.java.javaone;

public class Dog extends Animal {
    private double maxRunDistance = 500;

    private double maxSwimDistance = 10;

    private double maxJumpHeight = 0.5;

    public Dog(double maxRunDistance) {
        this.maxRunDistance = maxRunDistance;
    }

    public Dog() {
    }

    @Override
    public boolean run(double distance) {
        return distance <= maxRunDistance;
    }

    @Override
    public boolean swim(double distance) {
        return distance <= maxSwimDistance;
    }

    @Override
    public boolean jump(double height) {
        return height <= maxJumpHeight;
    }
}