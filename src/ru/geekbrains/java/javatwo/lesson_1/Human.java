package ru.geekbrains.java.javatwo.lesson_1;

public class Human implements Participant {

    private String name;
    private int maxRunDistance;
    private int maxJumpHeight;

    public Human(String name, int maxRunDistance, int maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    public String getName() {
        return name;
    }

    public int getMaxRunDistance() {
        return maxRunDistance;
    }

    public int getMaxJumpHeight() {
        return maxJumpHeight;
    }

    @Override
    public int run() {
        System.out.println("Human " + getName() + " is running. Run max distance: " + getMaxRunDistance());
        return getMaxRunDistance();
    }

    @Override
    public int jump() {
        System.out.println("Human " + getName() + " is jumping. Jump max height: " + getMaxJumpHeight());
        return getMaxJumpHeight();
    }
}
