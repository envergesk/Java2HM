package com.company.GeekBrains.HomeWork3;
import java.util.Map;
import java.util.Objects;

//2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
// В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать номер телефона по фамилии.
// Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при
// запросе такой фамилии должны выводиться все телефоны.

public class PhoneBook {
    private Map<String, String> map;

    public PhoneBook(Map<String, String> map) {
        this.map = map;
    }

    public void add(String name, String phoneNumber) {
        if (map.get(name) != null) {
            String doublicate = map.get(name);
            map.put(name, doublicate + ", " + phoneNumber);
        } else {
            map.put(name, phoneNumber);
        }
    }


    public String get(String key) {
        return map.get(key);
    }
}