package com.company.GeekBrains.HomeWork1;

public class Treadmill extends SportEquipment {
    private int length;

    public Treadmill(int length){
        super();
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    void toEquipment(Object obj) {
        if (obj instanceof Runnable) {
            Runnable runner = (Runnable) obj;
            runner.run(this);
        } else {
            System.out.println(obj + " can't run through the " + this + this.number);
        }
    }
}
