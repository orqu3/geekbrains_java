package ru.geekbrains.java.javaone;

public class Cat extends Animal {
    private double maxRunDistance = 200;

    private double maxJumpHeight = 2;

    @Override
    public boolean run(double distance) {
        return distance <= maxRunDistance;
    }

    @Override
    public boolean swim(double distance) {
        System.out.println("Cats can't swim!");
        return false;
    }

    @Override
    public boolean jump(double height) {
        return height <= maxJumpHeight;
    }
}
