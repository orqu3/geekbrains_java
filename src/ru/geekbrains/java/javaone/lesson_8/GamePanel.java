package ru.geekbrains.java.javaone.lesson_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JPanel implements Runnable, KeyListener {

    private static final long serialVersionUID = 1L;

    public static final int WIDTH = 400;
    public static final int HEIGHT = 400;

    private Thread thread;
    private boolean running = false;

    private BodyPart b;
    private ArrayList<BodyPart> snake;

    private Apple apple;
    private ArrayList<Apple> apples;

    private final Random r;

    private int xCoor = 10;
    private int yCoor = 10;
    private int size = 5;

    private boolean right = true;
    private boolean left = false;
    private boolean up = false;
    private boolean down = false;

    private int ticks = 0;

    public GamePanel() {

        setFocusable(true);

        addKeyListener(this);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        r = new Random();

        snake = new ArrayList<BodyPart>();
        apples = new ArrayList<Apple>();

        start();
    }

    public void start() {
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void tick() {

        if (snake.size() == 0) {
            b = new BodyPart(xCoor, yCoor, 10);
            snake.add(b);
        }
        if (apples.size() == 0) {
            int xCoor = r.nextInt(39);
            int yCoor = r.nextInt(39);

            apple = new Apple(xCoor, yCoor, 10);
            apples.add(apple);
        }

        for (int i = 0; i < apples.size(); i++) {
            if (xCoor == apples.get(i).getxCoor() &&
                    yCoor == apples.get(i).getyCoor()) {
                size++;
                apples.remove(i);
                i++;
            }
        }

        for (int i = 0; i < snake.size(); i++) {
            if (xCoor == snake.get(i).getxCoor() &&
                    yCoor == snake.get(i).getyCoor()) {
                if (i != snake.size() - 1) {
                    System.out.println("GAME OVER");
                    stop();
                }
            }
        }
        if (xCoor < 0 || xCoor > 39 || yCoor < 0 || yCoor > 39) {
            System.out.println("GAME OVER");
            stop();
        }

        ticks++;

        if (ticks > 1500000) {
            if (right) xCoor++;
            if (left) xCoor--;
            if (up) yCoor--;
            if (down) yCoor++;

            ticks = 0;

            b = new BodyPart(xCoor, yCoor, 10);
            snake.add(b);

            if (snake.size() > size) {
                snake.remove(0);
            }
        }
    }

    public void paint(Graphics g) {

        g.clearRect(0, 0, WIDTH, HEIGHT);
        Color myColor = new Color(147, 229, 105, 255);
        g.setColor(myColor);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        for (int i = 0; i < WIDTH / 10; i++) {
            g.drawLine(i * 10, 0, i * 10, HEIGHT);
        }

        for (int i = 0; i < HEIGHT / 10; i++) {
            g.drawLine(0, i * 10, HEIGHT, i * 10);
        }

        for (int i = 0; i < snake.size(); i++) {
            snake.get(i).draw(g);
        }
        for (int i = 0; i < apples.size(); i++) {
            apples.get(i).draw(g);
        }
    }

    @Override
    public void run() {
        while (running) {
            tick();
            repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_RIGHT && !left) {
            right = true;
            up = false;
            down = false;
        }

        if (key == KeyEvent.VK_LEFT && !right) {
            left = true;
            up = false;
            down = false;
        }

        if (key == KeyEvent.VK_UP && !down) {
            up = true;
            right = false;
            left = false;
        }

        if (key == KeyEvent.VK_DOWN && !up) {
            down = true;
            right = false;
            left = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
