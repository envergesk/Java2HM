package com.company.GeekBrains.HomeWork2;

public class MyArrayDataException extends Exception{
    public MyArrayDataException(int i, int j, int sum) {
        super("Wrong number in " + i + " " + j + ". The final sum was " + sum);
    }
}
