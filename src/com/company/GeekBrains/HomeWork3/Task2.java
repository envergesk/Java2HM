package com.company.GeekBrains.HomeWork3;

import java.util.HashMap;
import java.util.Map;

public class Task2 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap();
        map.put("Sokolov", "1131233");
        map.put("Medvedev", "1445688");
        map.put("Brown", "1243787");
        map.put("Bond", "0074007");

        PhoneBook phoneBook = new PhoneBook(map);
        System.out.println("Sokolov "+ phoneBook.get("Sokolov"));

        phoneBook.add("Morgan", "4772316");
        System.out.println("Morgan " + phoneBook.get("Morgan"));
        phoneBook.add("Sokolov", "1111111");
        System.out.println("Sokolov " + phoneBook.get("Sokolov"));

    }
}

