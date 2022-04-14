package com.company.GeekBrains.HomeWork1;

public class HomeWorkApp {
    public static void main(String[] args) {
        Human sergey = new Human("Sergey", 10, 5000);
        Human andrey = new Human("Andrey", 20, 3000);

        Cat boosya = new Cat("Boosya", 100, 1000);
        Cat snejok = new Cat("Snejok", 50, 2000);

        Robot t800 = new Robot("T800", 50, 2000);
        Robot t1000 = new Robot("T1000", 500, 20000);

        Wall woodenWall = new Wall(5);
        Wall brickWall = new Wall(15);
        Wall chineseWall = new Wall(60);

        Treadmill firstTreadmill = new Treadmill(1000);
        Treadmill secondTreadmill = new Treadmill(2000);
        Treadmill thirdTreadmill = new Treadmill(4500);

        Wall[] walls = {woodenWall, brickWall, chineseWall};
        Treadmill[] treadmills = {firstTreadmill, secondTreadmill, thirdTreadmill};
        SportEquipment[] sportEquipments = {woodenWall, brickWall, chineseWall, firstTreadmill, secondTreadmill, thirdTreadmill};

        Jumpable[] jumpers = {sergey, andrey, boosya, snejok, t800, t1000};
        Runnable[] runners = {sergey, andrey, boosya, snejok, t800, t1000};

        for (Wall wall : walls) {
            for (Jumpable jumper : jumpers) {
                if (jumper instanceof Human) {
                    Human human = (Human) jumper;
                    if (!human.isJumpTired()) {
                        continue;
                    } else {
                        human.jump(wall);
                        human.canJump(wall);
                    }
                } else if (jumper instanceof Cat) {
                    Cat cat = (Cat) jumper;
                    if (!cat.isJumpTired()) {
                        continue;
                    } else {
                        cat.jump(wall);
                        cat.canJump(wall);
                    }
                } else if (jumper instanceof Robot) {
                    Robot robot = (Robot) jumper;
                    if (!robot.isJumpTired()) {
                        continue;
                    } else {
                        robot.jump(wall);
                        robot.canJump(wall);
                    }
                }
            }
        }
        for (Treadmill treadmill : treadmills) {
            for (Runnable runner : runners) {
                if (runner instanceof Human) {
                    Human human = (Human) runner;
                    if (!human.isRunTired()){
                        continue;
                    }else{
                        human.run(treadmill);
                        human.canRun(treadmill);
                    }
                } else if (runner instanceof Cat) {
                    Cat cat = (Cat) runner;
                    if (!cat.isRunTired()){
                        continue;
                    } else {
                        cat.run(treadmill);
                        cat.canRun(treadmill);
                    }
                } else if (runner instanceof Robot) {
                    Robot robot = (Robot) runner;
                    if (!robot.isRunTired()){
                        continue;
                    } else {
                        robot.run(treadmill);
                        robot.canRun(treadmill);
                    }
                }
            }
        }

    }
}
