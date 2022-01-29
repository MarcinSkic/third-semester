package com.defaultcompany;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    /*Ship[] stateczki = new Ship[4];
        stateczki[0] = new Ship("Titanic",Ship.FULL,2000);
        stateczki[1] = new Ship("Merlin",Ship.EMPTY,1000);
        stateczki[2] = new Ship("Vandal", Ship.FULL, 200);
        stateczki[3] = new Ship("Apoxor",Ship.EMPTY,500);
        for (var x: stateczki
             ) {
            System.out.println(x.toString((Ship ship)->{
                return "nazwa={"+ship.getName()+"},stan={"+ship.getState()+"},ladownosc={"+ship.getCapacity()+"}";
            }));
        }

        FileWriter fileWriter;

        try {
            fileWriter = new FileWriter(new File("Statki.txt"),true);
            for (var x: stateczki
            ) {
                fileWriter.append(x.toString((Ship ship)->{
                    return ship.getName()+";"+ship.getState()+";"+ship.getCapacity()+"\n";
                }));
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Ship> statki2 = new ArrayList<Ship>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("Statki.txt")));
            String linia;

            while((linia = reader.readLine())!= null){
                var tab = linia.split(";");
                statki2.add(new Ship(tab[0],Integer.parseInt(tab[1]),Integer.parseInt(tab[2])));
            }

            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (var x: statki2) {
            System.out.println(x.toString((Ship ship)->{
                return ship.getState()+","+ship.getCapacity()+","+ship.getName();
            }));
        }*/
        int[] tab = new int[300];

        Watek watek = new Watek(tab);
        Thread thread = new Thread(watek);
        thread.start();

        while(true){
            if(!thread.isAlive()){
                break;
            }
        }

        Watek2 watek2 = new Watek2(tab);
        Thread thread2 = new Thread(watek2);
        thread2.start();
    }
}
