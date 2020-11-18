package ru.geekbrains.java.javaone.lesson_7;

public class Cat {

    private String name;
    private int appetite;
    private boolean fullness = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean getFullness() {
        return fullness;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public void setFullness(boolean fullness) {
        this.fullness = fullness;
    }

    public void eat(Plate plate) {
        if (plate.getFood() >= this.appetite) {
            System.out.println(this.name + " is eating");
            plate.decreaseFood(this.appetite);
            setFullness(true);
        } else {
            System.out.println("There is not enough food for the " + this.name);
        }
    }

    public void printInfoAboutCatFullness() {
        if (this.fullness) {
            System.out.println(this.name + " is full and happy!");
        } else {
            System.out.println(this.name + " is hungry and sad...");
        }
    }
}
