package com.epam;

public class Sapphire extends Stone {

    Sapphire(float w, float p, int t) {
        super(w, p, t);
    }

    public void name() {
        System.out.println("It's Sapphire.");
    }
}