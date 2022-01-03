package com.defaultcompany;

import java.util.concurrent.ThreadLocalRandom;

public class Watek implements  Runnable{

    int[] tab;

    public Watek(int[] tab) {
        this.tab= tab;
    }


    @Override
    public void run() {
        for(int i = 0 ; i < tab.length; i++){
            tab[i] = ThreadLocalRandom.current().nextInt(101)+100;
        }
    }
}
