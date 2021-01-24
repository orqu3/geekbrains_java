package ru.geekbrains.java.javatwo.lesson_3;

/*
2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров. В этот
телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать номер телефона по
фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при
запросе такой фамилии должны выводиться все телефоны.
Желательно как можно меньше добавлять своего, чего нет в задании (т.е. не надо в телефонную запись добавлять еще
дополнительные поля (имя, отчество, адрес), делать взаимодействие с пользователем через консоль и т.д.). Консоль
желательно не использовать (в том числе Scanner), тестировать просто из метода main() прописывая add() и get().
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Phonebook {

    private final Map<String, Set<String>> surnamesAndPhoneNumbers = new HashMap<>();

    public static void main(String[] args) {

        Phonebook phonebook = new Phonebook();

        phonebook.add("Johnson", "77-77-77");
        phonebook.add("Smith", "11-11-11");
        phonebook.add("Bell", "66-66-66");
        phonebook.add("Adams", "55-55-55");
        phonebook.add("Smith", "44-44-44");

        System.out.println(phonebook.get("Bell"));
        System.out.println(phonebook.get("Smith"));
    }

    public void add(String surname, String phoneNumber) {
        Set<String> phoneNumbers = getPhoneNumbers(surname);
        phoneNumbers.add(phoneNumber);
    }

    public Set<String> getPhoneNumbers(String surname) {
        Set<String> phoneNumbers = surnamesAndPhoneNumbers.getOrDefault(surname, new HashSet<>());

        if (phoneNumbers.isEmpty()) {
            surnamesAndPhoneNumbers.put(surname, phoneNumbers);
        }
        return phoneNumbers;
    }

    public Set<String> get(String surname) {
        return getPhoneNumbers(surname);
    }
}

