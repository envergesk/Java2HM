package com.company.GeekBrains.HomeWork1;

public class Robot implements Runnable, Jumpable {
    private String name;
    private int jumpEnergy;
    private int runEnergy;
    private boolean jumpTired;
    private boolean runTired;

    public Robot(String name, int jumpEnergy, int runEnergy) {
        this.name = name;
        this.jumpEnergy = jumpEnergy;
        this.runEnergy = runEnergy;
        this.jumpTired = true;
        this.runTired = true;
    }

    @Override
    public void run(Treadmill treadmill) {
        if (this.runEnergy - treadmill.getLength() < 0) {
            System.out.println(this.name + " is tired and can't run through the " + treadmill.number);
        } else {
            this.runEnergy -= treadmill.getLength();
            System.out.println(this.name + " ran " + treadmill.number + " length " + treadmill.getLength() + "m");
        }
    }

    @Override
    public boolean canRun(Treadmill treadmill) {
        this.runTired = this.runEnergy - treadmill.getLength() < 0;
        return runTired;
    }

    @Override
    public void jump(Wall wall) {
        if (this.jumpEnergy - wall.getHeight() < 0) {
            System.out.println(this.name + " is tired and can't jump around the " + wall.number);
        } else {
            this.jumpEnergy -= wall.getHeight();
            System.out.println(this.name + " jumped around the " + wall.number + " height " + wall.getHeight());
        }
    }

    public String getName() {
        return name;
    }

    public int getJumpEnergy() {
        return jumpEnergy;
    }

    public int getRunEnergy() {
        return runEnergy;
    }

    public boolean isJumpTired() {
        return jumpTired;
    }

    public boolean isRunTired() {
        return runTired;
    }

    @Override
    public boolean canJump(Wall wall) {
        this.jumpTired = this.jumpEnergy - wall.getHeight() < 0;
        return this.jumpTired;
    }
}
