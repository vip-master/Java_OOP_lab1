package com.epam;

public abstract class Stone {
    private float weight = 0;
    private float price = 0;
    private int transparency = 0;

    private float cost = 0;

    Stone(float w, float p, int t) {
        weight = w;
        transparency = t;
        price = p;

        cost = price * weight;
    }

    float getWeight() {
        return weight;
    }

    float getCost() {
        return cost;
    }

    float getWorth() {
        return price;
    }

    int getTransparency() {
        return transparency;
    }

    boolean isOk(int min, int max) {
        return (transparency <= max && transparency >= min);
    }

    public boolean isOk(int x, boolean sign) {
        if (transparency > x) return sign;
        return !sign;
    }

    public abstract void name();
}
