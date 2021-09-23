package com.company;

public class Main {

    public static void main(String[] args) {
        int[] min = new int[] {3, 15, 2, 6};
	    Laundry laundry = new Laundry(min, 2);
        laundry.createMachines();
        laundry.doWashing();
        System.out.println(laundry.countServiceMinutes());
    }
}
