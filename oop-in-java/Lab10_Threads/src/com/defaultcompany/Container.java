package com.defaultcompany;

public class Container {
    int value = 0;
    boolean full = false;

    synchronized void deliver(int newValue){
        try {
            while (full) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        value = newValue;
        full = true;
        notifyAll();
        System.out.println("Dostarczono!");
    }

    synchronized int consume(){
        try {
            while (!full) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        var temp = value;
        full = false;
        notifyAll();
        System.out.println("Odebrano");
        return temp;
    }
}
