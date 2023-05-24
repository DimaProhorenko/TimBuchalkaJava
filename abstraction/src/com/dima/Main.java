package com.dima;

public class Main {
    public static void main(String[] args) {
        Dog spike = new Dog("mammal", "large", 55.2);
        Fish f = new Fish("fish", "medium", 1.02);
//        doAnimalStuff(spike);
//        doAnimalStuff(f);
//        animalInstance(spike);
        Animal horse = new Horse("Clydesdale", "large", 1000);
        doAnimalStuff(horse);
    }

    public static void doAnimalStuff(Animal a) {
        a.move("fast");
        a.makeNoise();

        if(a instanceof Mammal currentMammal) {
            currentMammal.shedHair();
        }
    }

    public static void animalInstance(Animal a) {
        System.out.println(a.getInstanceType());
    }
}
