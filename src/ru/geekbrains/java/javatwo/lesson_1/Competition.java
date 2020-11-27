package ru.geekbrains.java.javatwo.lesson_1;

/*
1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти классы должны уметь бегать и
 прыгать (методы просто выводят информацию о действии в консоль).
2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять
соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль (успешно пробежал, не смог
пробежать и т.д.). У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и
прыжки.
3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.
 */

public class Competition {

    public static void main(String[] args) {

        Robot robot = new Robot("Stan", 1000, 100);
        Human human = new Human("Alice", 300, 10);
        Cat cat = new Cat("Tom", 600, 200);

        Participant[] participants = new Participant[3];
        participants[0] = robot;
        participants[1] = human;
        participants[2] = cat;

        Wall wall = new Wall(50);
        Track track = new Track(300);

        Obstacle[] obstacles = new Obstacle[2];
        obstacles[0] = wall;
        obstacles[1] = track;

        for (Participant participant : participants) {
            for (Obstacle obstacle : obstacles) {
                if (!obstacle.passObstacle(participant))
                    break;
            }
        }
    }
}


