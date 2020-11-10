package ru.geekbrains.java.javaone;

/*
1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
2. Конструктор класса должен заполнять эти поля при создании объекта;
3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
4. Создать массив из 5 сотрудников.
Пример:
Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для
* каждой ячейки массива задаем объект
persArray[1] = new Person(...);
...
persArray[4] = new Person(...);

5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
 */

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phoneNumber;
    private double salary;
    private int age;

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("John Adams", "accountant", "johnA@gmail.com", "07773534455", 4500, 44);
        employees[1] = new Employee("Olivia Bell", "clerk", "be11@gmail.com", "0786768899", 2100, 26);
        employees[2] = new Employee("Boris Cox", "manager", "coxBoris@gmail.com", "0765443322", 6000, 56);
        employees[3] = new Employee("Alice Fisher", "lawyer", "alice_in_wonderland@gmail.com", "0778885436", 4300, 36);
        employees[4] = new Employee("Harry Richardson", "economist", "harryRrr@gmail.com", "0786542278", 4000, 28);

        for (Employee employee : employees) {
            if (employee.getAge() > 40) {
                employee.printFullEmployeeInfo();
            }
        }
    }

    public Employee(String fullName, String position, String email, String phoneNumber, double salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void printFullEmployeeInfo() {
        System.out.printf("Employee name: %15s, Position: %15s, Email: %20s, Phone number: %15s, Salary: %.2f, " +
                "Age: %2d\n", this.fullName, this.position, this.email, this.phoneNumber, this.salary, this.age);
    }
}

