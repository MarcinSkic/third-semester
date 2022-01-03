package com.defaultcompany;

public class Main {

    public static void main(String[] args) {
        /*
	    Lottery lottery1 = new Lottery(1);
	    Thread thread1 = new Thread(lottery1);
	    Thread thread2 = new Thread(lottery1);
	    Thread thread3 = new Thread(lottery1);
	    Thread thread4 = new Thread(lottery1);
	    Thread thread5 = new Thread(lottery1);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();*/


        Container container = new Container();

        Thread thread1 = new Thread(new Consumer(container,1));
        Thread thread2 = new Thread(new Consumer(container,2));
        Thread thread3 = new Thread(new DeliveryMan(container,1));
        Thread thread4 = new Thread(new DeliveryMan(container,2));
        Thread thread5 = new Thread(new DeliveryMan(container,3));
        Thread thread6 = new Thread(new DeliveryMan(container,4));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();

        /*
        Frier frier = new Frier(10);
        Decorator decorator = new Decorator(frier.fried,10);
        Roller roller = new Roller(decorator.decorated,10);

        Thread frierThr = new Thread(frier);
        Thread decoratorThr = new Thread(decorator);
        Thread rollerThr = new Thread(roller);

        frierThr.start();
        decoratorThr.start();
        rollerThr.start();

        try{
            frierThr.join();
            decoratorThr.join();
            rollerThr.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Rolled: "+roller.rolled);
        */

    }
}
