package com.defaultcompany;

import java.util.SortedMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Frier implements Runnable{
    public BlockingQueue<Pancake> fried = new LinkedBlockingQueue<>();
    private int amount;

    public Frier(int amount) {
        this.amount = amount;
    }

    @Override
    public void run() {
        for(int i = 0; i< amount;i++){
            Pancake pancake = new Pancake(i);
            try{
                Thread.sleep(ThreadLocalRandom.current().nextInt(100));
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            pancake.state = State.Fried;
            fried.add(pancake);
            System.out.println("Fried pancakes: " + fried);
        }
    }
}
