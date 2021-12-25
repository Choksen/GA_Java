package com.maks.collections.Animal;

public abstract class Pet {
    private final String color;
    private final int age;
    private final boolean hasWool;

    public Pet(final String color, final int age, final boolean hasWool) {
        this.color = color;
        this.age = age;
        this.hasWool = hasWool;
    }

}
