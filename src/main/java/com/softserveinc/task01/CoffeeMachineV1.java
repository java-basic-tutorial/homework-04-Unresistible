package com.softserveinc.task01;

public class CoffeeMachineV1 extends AbstractCoffeeMachine {
    private final int[] espresso = {22, 30};
    private final int[] americano = {22, 100};

    public boolean makeEspresso() {
        return super.makeCoffee(espresso[0], espresso[1]);
    }

    public boolean makeAmericano() {
        return super.makeCoffee(americano[0], americano[1]);
    }

    public CoffeeMachineV1(int coffeeBeanStorageCapacity, int waterReservoirCapacity, int wasteCoffeeBeanCapacity) {
        super(coffeeBeanStorageCapacity, waterReservoirCapacity, wasteCoffeeBeanCapacity);
    }
}