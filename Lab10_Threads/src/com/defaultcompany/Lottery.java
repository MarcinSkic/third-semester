package com.defaultcompany;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Lottery implements Runnable{
    int numer;
    public Lottery(int numer){
        this.numer = numer;

    }
    @Override
    public void run() {
        //zadanie 1
        Random random = new Random();
        //random.setSeed(0);
        System.out.println("Rozne: w" + numer + " random.nextInt(101) = " + random.nextInt(101));
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
