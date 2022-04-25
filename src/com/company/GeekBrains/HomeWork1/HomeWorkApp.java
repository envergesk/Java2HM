package com.company.GeekBrains.HomeWork1;

public class HomeWorkApp {
    public static void main(String[] args) {
        Human sergey = new Human("Sergey", 25, 300, 40);
        Human andrew = new Human("Andrew", 26, 1500, 50);

        Cat snejok = new Cat("Snejok", "white", 360, 60);
        Cat gerakl = new Cat("Gerakl", "grey", 1200, 70);

        Robot alpha = new Robot("Alpha", "a1", 300, 20);
        Robot beta = new Robot("Beta", "b23", 400, 25);

        Runnable[] runners = {sergey, andrew, snejok, gerakl, alpha, beta};
        Jumpable[] jumpers = {sergey, andrew, snejok, gerakl, alpha, beta};

        Treadmill treadmill1 = new Treadmill(200);
        Treadmill treadmill2 = new Treadmill(150);
        Wall wall1 = new Wall(15);
        Wall wall2 = new Wall(20);
        SportEquipment[] sportEquipments = {treadmill1, treadmill2, wall1, wall2};

        for (SportEquipment sportEquipment : sportEquipments) {

        }

//        Object[] objects = new Object[]{sergey, andrew, snejok, gerakl, alpha, beta};
//        for (Object object : objects) {
//            if (object instanceof Jumpable) {
//                for (SportEquipment sportEquipment : sportEquipments) {
//                    if (sportEquipment instanceof Treadmill) {
//                        Treadmill treadmill = (Treadmill) sportEquipment;
//                        treadmill.toEquipment(object);
//                    }
//                }
//            }
//            if (object instanceof Runnable) {
//                for (Object sportEquipment : sportEquipments) {
//                    if (sportEquipment instanceof Wall) {
//                        Wall wall = (Wall) sportEquipment;
//                        wall.toEquipment(object);
//                    }
//                }
//            }
//        }
    }
}

