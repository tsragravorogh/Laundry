package com.tsragravorogh;

public class Main {

    public static void main(String[] args) {
        int[] min = new int[] {3, 7, 8, 4};
	    Laundry laundry = new Laundry(min, 1);
        laundry.createMachines();
        laundry.doWashing();
        System.out.println(laundry.countServiceMinutes());
    }
}
