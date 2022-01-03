package com.defaultcompany;

import java.util.concurrent.ThreadLocalRandom;

public class InsertData implements Runnable{

    LittleSantaHelper lsh;

    public InsertData(LittleSantaHelper lsh) {
        this.lsh = lsh;
    }

    @Override
    public void run() {
        for(int i = 0; i < 50;i++){
            lsh.SetNumber(i,DoJob(()->{
                return ThreadLocalRandom.current().nextInt(41)+10;
            }));
        }
    }
    public int DoJob(Lottery lottery){
       return lottery.GetNumber();
    }
}
