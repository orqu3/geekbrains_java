package ru.geekbrains.java.javathree.lesson_5;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {

    private final Semaphore semaphore;

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        semaphore = new Semaphore(MainClass.CARS_COUNT / 2);
    }

    @Override
    public void go(Car c) {

        try {
            if (!semaphore.tryAcquire()) {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                semaphore.acquire();
            }
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(c.getName() + " закончил этап: " + description);
            semaphore.release();
        }
    }
}
