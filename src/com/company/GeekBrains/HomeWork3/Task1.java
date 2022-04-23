package com.company.GeekBrains.HomeWork3;
//1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
// Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
// Посчитать сколько раз встречается каждое слово.

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        String[] strings = {"clone", "fight", "clone", "clone", "arcane", "mystery", "fight", "fantastic", "sea", "fantastic", "ultimate", "implements", "arcade", "arcade"};

        Set<String> set = new HashSet<>(Arrays.asList(strings));
        System.out.println(set);
        List<String> list = new ArrayList<>(Arrays.asList(strings));
        System.out.println(list);

        Map<String, Integer> map = new HashMap<>();
        Iterator<String> iter = set.iterator();
        while (iter.hasNext()){
            int counter = 0;
            String str = iter.next();
            for (String s : list) {
                if (str.equals(s)) {
                    counter++;
                }
            }
            map.put(str, counter);
        }
        System.out.println(map);
    }

}