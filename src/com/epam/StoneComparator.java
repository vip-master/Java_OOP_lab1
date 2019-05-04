package com.epam;

import java.util.Comparator;

public class StoneComparator implements Comparator<Stone> {
    @Override
    public int compare(Stone o1, Stone o2) {
        return (int) (o1.getWorth() - o2.getWorth());
    }
}
