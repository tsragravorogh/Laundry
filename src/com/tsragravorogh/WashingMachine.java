package com.tsragravorogh;

import java.util.Comparator;

public class WashingMachine{
    private int minWork = 0;
    private int totalWorks = 0;

    public WashingMachine() {

    }

    public int getMinWork() {
        return minWork;
    }

    public void setMinWork(int minWork) {
        this.minWork = minWork;
    }

    public void doWash(int min) {
        minWork = min;
        totalWorks += min;
    }

    public int getTotalWorks() {
        return totalWorks;
    }

    public static final Comparator<WashingMachine> COMPARE_BY_MINWORK = Comparator.comparingInt(WashingMachine::getMinWork);
}
