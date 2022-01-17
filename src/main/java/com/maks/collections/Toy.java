package com.maks.collections;

public class Toy {
    final int model;
    final String view;
    final Boolean isMetal;

    public Toy(final int model, final String view, final Boolean isMetal) {
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
