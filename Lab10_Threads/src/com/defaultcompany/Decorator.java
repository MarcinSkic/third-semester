package com.defaultcompany;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Decorator implements Runnable{
    public BlockingQueue<Pancake> fried;
    public BlockingQueue<Pancake> decorated = new LinkedBlockingQueue<>();
    private int amount;

    public Decorator(BlockingQueue<Pancake> fried, int amount) {
        this.fried = fried;
        this.amount = amount;
    }

    @Override
    public void run() {
        Pancake pancake = null;
        for(int i = 0; i< amount;i++){
            try{
                pancake = fried.take();
                Thread.sleep(ThreadLocalRandom.current().nextInt(100));
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            pancake.state = State.Decorated;
            decorated.add(pancake);
            System.out.println("Decorated pancakes: " + decorated);
        }
    }
}
