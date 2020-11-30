package ru.geekbrains.java.javatwo.lesson_1;

public class Robot implements Participant {

    private String name;
    private int maxRunDistance;
    private int maxJumpHeight;

    public Robot(String name, int maxRunDistance, int maxJumpHeight) {
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
        System.out.println("Robot " + getName() + " is running. Max run distance: " + getMaxRunDistance());
        return getMaxRunDistance();
    }

    @Override
    public int jump() {
        System.out.println("Robot " + getName() + " is jumping. Max jump height: " + getMaxJumpHeight());
        return getMaxJumpHeight();
    }
}
