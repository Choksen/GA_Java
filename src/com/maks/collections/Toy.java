package com.maks.collections;

public class Toy {
    int model;
    String view;
    Boolean isMetal;

    public Toy(int model, String view, Boolean isMetal) {
        this.model = model;
        this.view = view;
        this.isMetal = isMetal;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "model=" + model +
                ", view='" + view + '\'' +
                ", isMetal=" + isMetal +
                '}';
    }
}
