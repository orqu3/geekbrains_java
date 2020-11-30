package ru.geekbrains.java.javatwo.lesson_1;

public class Wall implements Obstacle {

    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean passObstacle(Participant participant) {
        if(participant.jump() >= getHeight()) {
            System.out.println("Participant jumped over the wall.");
            return true;
        } else {
            System.out.println("Participant could not jump over the wall.");
            return false;
        }
    }
}
