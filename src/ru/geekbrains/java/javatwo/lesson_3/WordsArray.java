package ru.geekbrains.java.javatwo.lesson_3;

/*
1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных
слов, из которых состоит массив (дубликаты не считаем). Посчитать сколько раз встречается каждое слово.
 */

import java.util.*;

public class WordsArray {

    public static void main(String[] args) {

        List<String> words = new ArrayList<>();

        words.add("bus");
        words.add("car");
        words.add("train");
        words.add("tram");
        words.add("car");
        words.add("bus");
        words.add("ship");
        words.add("train");
        words.add("train");
        words.add("taxi");
        words.add("bus");
        words.add("underground");
        words.add("boat");
        words.add("taxi");
        words.add("helicopter");

        printUniqueWordsFromList(words);
        printWordsCount(words);
    }

    public static void printUniqueWordsFromList(List<String> words) {
        Set<String> uniqueWords = new HashSet<>(words);
        System.out.println("Unique words from list: " + uniqueWords);
    }

    public static void printWordsCount(List<String> words) {

        Map<String, Integer> duplicatesCount = new HashMap<>();

        for (String str : words) {
            if (duplicatesCount.containsKey(str)) {
                duplicatesCount.put(str, duplicatesCount.get(str) + 1);
            } else {
                duplicatesCount.put(str, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : duplicatesCount.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
