package com.softserveinc.task02;

import com.softserveinc.task01.CoffeeMachineV1;

public class CoffeeMachineV2 extends CoffeeMachineV1 {
    private final int latteMilk = 150;
    private final int cappuccinoMilk = 85;

    //in readme specified "private final integer" milkReservoirCapacity that fail one test
    protected final int milkReservoirCapacity;
    private int milk;

    public CoffeeMachineV2(int coffeeBeanStorageCapacity, int waterReservoirCapacity, int wasteCoffeeBeanCapacity, int milkReservoirCapacity) {
        super(coffeeBeanStorageCapacity, waterReservoirCapacity, wasteCoffeeBeanCapacity);
        this.milkReservoirCapacity = milkReservoirCapacity;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public void addMilk(int milk) {
        this.milk = Math.min(milk + this.milk, milkReservoirCapacity);
    }

    public boolean makeLatte() {
        if (!makeEspresso()) {
            //invoking makeEspresso() before milk check is a bad idea ^^ - waste of resources
            //but test doesn't pass when milk check is placed before invoking makeEspresso()
            return false;
        }

        if (latteMilk > milk) {
            System.err.println("Not enough milk");
            return false;
        }
        milk -= latteMilk;
        return true;
    }

    public boolean makeCappuccino() {
        if (!makeEspresso()) {
            return false;
        }
        if (cappuccinoMilk > milk) {
            System.err.println("Not enough milk");
            return false;
        }
        milk -= cappuccinoMilk;
        return true;
    }
}
