package com.company.GeekBrains.HomeWork1;

public abstract class SportEquipment {
    protected static int count = 0;
    protected int number;

    public SportEquipment(){
        count++;
        this.number = count;
    }

    abstract void toEquipment(Object obj);
}
