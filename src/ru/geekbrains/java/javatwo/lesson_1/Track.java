package ru.geekbrains.java.javatwo.lesson_1;

public class Track implements Obstacle {

    private int length;

    public Track(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public boolean passObstacle(Participant participant) {
        if(participant.run() >= getLength()) {
            System.out.println("Participant ran the distance.");
            return true;
        } else {
            System.out.println("Participant could not run the distance.");
            return false;
        }
    }
}
