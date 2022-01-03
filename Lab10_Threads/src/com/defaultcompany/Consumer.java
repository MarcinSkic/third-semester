package com.defaultcompany;

public class Consumer implements Runnable {

    Container container;
    int index;

    public Consumer(Container container, int index) {
        this.container = container;
        this.index = index;
    }

    @Override
    public void run() {
        for(int i = 0; i < 40; i++){
            container.consume();
        }
        System.out.println("Consumer nr "+index+" finished the job");
    }
}
