package com.defaultcompany;

public class Watek2 implements Runnable{

    int[] tab;

    public Watek2(int[] tab) {
        this.tab= tab;
    }

    @Override
    public void run() {
        for (var x: tab
             ) {
            System.out.println(x);

        }
    }
}
