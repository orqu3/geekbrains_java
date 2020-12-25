package ru.geekbrains.java.javathree.lesson_1.fruits_and_boxes;

/*
3. Большая задача:
a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку
нельзя сложить и яблоки, и апельсины;
c. Для хранения фруктов внутри коробки можете использовать ArrayList;
d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес яблока
- 1.0f, апельсина - 1.5f, не важно в каких это единицах);
e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в
compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем
сравнивать с коробками с апельсинами);
f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку
фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается, а в
другую перекидываются объекты, которые были в этой коробке;
g. Не забываем про метод добавления фрукта в коробку.
 */
public class FruitsAndBoxesApp {

    public static void main(String[] args) {

        Box<Apple> appleBox = new Box<>();

        for (int i = 0; i < 10; i++) {
            appleBox.addFruit(new Apple());
        }

        System.out.println("Total weight of box with apple: " + appleBox.getWeight());

        Box<Orange> orangeBox = new Box<>();

        for (int i = 0; i < 15; i++) {
            orangeBox.addFruit(new Orange());
        }

        System.out.println("Total weight of box with orange: " + orangeBox.getWeight());

        System.out.println("Weights of boxes are equal: " + appleBox.compare(orangeBox));

        Box<Apple> anotherAppleBox = new Box<>();

        appleBox.replaceFruitToAnotherBox(anotherAppleBox);

        System.out.println("Total weight of box with apple after replace: " + appleBox.getWeight());
        System.out.println("Total weight of another box with apple: " + anotherAppleBox.getWeight());

    }
}
