package com.maks.collections;

public class Box implements Comparable<Box> {
    int weight;
    int length;
    int width;
    int height;

    Box(int weight, int length, int width, int height) {
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Box{" +
                "weight=" + weight +
                ", length=" + length +
                ", width=" + width +
                ", height=" + height +
                '}';
    }

    @Override
    public int compareTo(Box box) {
        int compare = this.height - box.height;
        if (compare == 0) {
            return this.weight - box.weight;
        } else {
            return compare;
        }
    }
}
