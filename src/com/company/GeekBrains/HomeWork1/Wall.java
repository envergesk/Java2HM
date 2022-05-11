package com.company.GeekBrains.HomeWork1;

public class Wall extends SportEquipment{
    private int height;

    public Wall(int height){
        super();
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    void toEquipment(Object obj) {
        if (obj instanceof Jumpable) {
            Jumpable jumper = (Jumpable) obj;
            jumper.jump(this);
        } else {
            System.out.println(obj + " cant jump around the " + this + this.number);
        }
    }
}
