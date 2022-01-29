package com.defaultcompany;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        LittleSantaHelper lsh = new LittleSantaHelper();

        Thread watek = new Thread(new InsertData(lsh));
        //Thread watek = new Thread(new InsertData(lsh));
        watek.start();

        while(watek.isAlive()){

        }

        for(int i = 0; i < lsh.liczby.length;i++){
            System.out.println(lsh.liczby[i]);
        }


    }

}
