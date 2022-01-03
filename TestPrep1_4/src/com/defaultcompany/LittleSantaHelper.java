package com.defaultcompany;

import java.util.concurrent.ThreadLocalRandom;

public class LittleSantaHelper {
    public int[] liczby = new int[50];

    public synchronized void SetNumber(int index,int number){
        liczby[index] = number;
        try {
            wait(ThreadLocalRandom.current().nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(index == 50-1){
            notifyAll();
        }
    }

    public synchronized void GetNumber(){

    }
}
