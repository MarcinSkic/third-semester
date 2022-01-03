package com.defaultcompany;

import java.util.Random;

public class DeliveryMan implements Runnable{

    int index = 0;
    Container container;

    public DeliveryMan(Container container, int index) {
        this.container = container;
        this.index = index;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++){
            Random random = new Random();
            container.deliver(random.nextInt(300));
        }
        System.out.println("DeliveryMan nr "+index+" finished the job!");
    }
}
