package com.tsragravorogh;

import java.util.ArrayList;

public class Laundry {
    private ArrayList<WashingMachine> allMachines = new ArrayList<>();
    private int[] minutes;
    private int countOfWashMachine;
    private int clientsIndex = 0;


    public Laundry(int[] minutes, int countOfWashMachine) {
        for (int m:minutes) {
            if(m <= 0) throw new LaundryException("Elements of array must be positive");
        }
        this.minutes = minutes;
        this.countOfWashMachine = countOfWashMachine;
    }

    public void doWashing() {
        while (!isWorkDone()){
            int minWork = Integer.MAX_VALUE;
            for (WashingMachine wm: allMachines) {
                if(minWork > wm.getMinWork()) {
                    minWork = wm.getMinWork();
                }
            }
            for(WashingMachine wm: allMachines) {
                wm.setMinWork(wm.getMinWork() - minWork);
            }

            for (WashingMachine w : allMachines) {
                if(w.getMinWork() == 0) {
                    w.doWash(minutes[clientsIndex]);
                    clientsIndex++;
                }
            }
        }
    }

    public int countServiceMinutes() {
        int serviceMinutes = Integer.MIN_VALUE;
        for(WashingMachine wm: allMachines) {
            if(serviceMinutes < wm.getTotalWorks()) {
                serviceMinutes = wm.getTotalWorks();
            }
        }
        return serviceMinutes;
    }

    private boolean isWorkDone() {
        return clientsIndex == minutes.length;
    }

    public void createMachines(){
        for(int i = 0; i < countOfWashMachine; i++) {
            allMachines.add(new WashingMachine());
        }
    }

    public int getCountOfWashMachine() {
        return countOfWashMachine;
    }
}
