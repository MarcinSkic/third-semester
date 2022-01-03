package com.defaultcompany;

public class cos implements Runnable{

    String nazwa;

    public cos(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public void run() {
        for(int i = 0; i< 100; i++){
            System.out.println(nazwa+"Watkuje" + i);
            try {
                wait(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
