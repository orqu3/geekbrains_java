package ru.geekbrains.java.javathree.lesson_5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static final AtomicInteger atomicInteger;

    static {
        CARS_COUNT = 0;
    }

    static {
        atomicInteger = new AtomicInteger(0);
    }

    private final Race race;
    private final int speed;
    private final String name;
    private final CyclicBarrier cyclicBarrier;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CyclicBarrier cyclicBarrier) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.cyclicBarrier = cyclicBarrier;

    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            cyclicBarrier.await();
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        if (atomicInteger.incrementAndGet() == 1) {
            System.out.println(name + " выиграл гонку!");
        }

        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
