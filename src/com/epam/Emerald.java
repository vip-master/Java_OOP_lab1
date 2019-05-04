package com.epam;

public class Emerald extends Stone {

    Emerald(float w, float p, int t) {
        super(w, p, t);
    }

    public void name() {
        System.out.println("It's Emerald.");
    }
}