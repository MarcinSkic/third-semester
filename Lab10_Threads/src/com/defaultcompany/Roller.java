package com.defaultcompany;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Roller implements Runnable{
    public BlockingQueue<Pancake> decorated;
    public BlockingQueue<Pancake> rolled = new LinkedBlockingQueue<>();
    private int amount;

    public Roller(BlockingQueue<Pancake> decorated, int amount) {
        this.decorated = decorated;
        this.amount = amount;
    }

    @Override
    public void run() {
        Pancake pancake = null;
        for(int i = 0; i< amount;i++){
            try{
                pancake = decorated.take();
                Thread.sleep(ThreadLocalRandom.current().nextInt(100));
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            pancake.state = State.Rolled;
            rolled.add(pancake);
            System.out.println("Rolled pancakes: " + rolled);
        }
    }
}
