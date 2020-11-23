package ru.geekbrains.java.javaone.lesson_7;

/*
1. Расширить задачу про котов и тарелки с едой
2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а
 кот пытается покушать 15-20)
3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило
еды), сытость = true
4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть не может быть наполовину сыт (это
сделано для упрощения логики программы)
5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о
сытости котов в консоль
6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
 */

public class MainClass {

    public static void main(String[] args) {

        Cat cat = new Cat("Tom", 20);
        Plate plate = new Plate(30);
        plate.info();
        cat.printInfoAboutCatFullness();
        cat.eat(plate);
        plate.info();
        cat.printInfoAboutCatFullness();

        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Simon", 3);
        cats[1] = new Cat("Boris", 20);
        cats[2] = new Cat("Lana", 10);
        Plate plateForCats = new Plate(25);
        plateForCats.info();
        for (Cat value : cats) {
            value.printInfoAboutCatFullness();
        }
        for (Cat value : cats) {
            value.eat(plateForCats);
        }
        plateForCats.info();
        for (Cat value : cats) {
            value.printInfoAboutCatFullness();
        }
    }
}
