package com.tsragravorogh;

import java.util.*;

public class Laundry {
    private ArrayList<WashingMachine> allMachines = new ArrayList<>();
    private int[] minutes;
    private int countOfWashMachine;
    private int clientsIndex = 0;


    public Laundry(int[] minutes, int countOfWashMachine) {
        for (int m:minutes) {
            if(m <= 0) throw new IllegalArgumentException("Elements of array must be positive");
        }
        this.minutes = minutes;
        this.countOfWashMachine = countOfWashMachine;
    }

    public void doWashing() {
        while (!isWorkDone()){
            int minWork = getMinWork(allMachines);

            for(WashingMachine wm: allMachines) {
                wm.setMinWork(wm.getMinWork() - minWork);

                if(wm.getMinWork() == 0) {
                    wm.doWash(minutes[clientsIndex]);
                    clientsIndex++;
                }
            }
        }
    }

    private int getMinWork(ArrayList<WashingMachine> allMachines) {
        allMachines.sort(WashingMachine.COMPARE_BY_MINWORK);
        return allMachines.get(0).getMinWork();
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
