package com.defaultcompany;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Ship> statki = new ArrayList<Ship>();

        statki.add(new Ship("Bismarck",8,Ship.UZBROJONY));
        statki.add(new Ship("Hood",8,Ship.NIEUZBROJONY));
        statki.add(new Ship("Iowa",9,Ship.UZBROJONY));
        statki.add(new Ship("Prinz Eugen",10,Ship.UZBROJONY));


        try {
            FileWriter savior = new FileWriter(new File("Zapisane.txt"),true);
            for (var x: statki) {
                savior.append(x.toString((Ship ship)->{

                    return ship.getName()+","+ship.getAmountOfWeapons()+","+ship.getWeaponsState()+"\n";
                }));
            }
            savior.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("Zapisane.txt")));

            String linia;
            while((linia = reader.readLine())!=null){
                var tab = linia.split(",");
                statki.add(new Ship(tab[0],Integer.parseInt(tab[1]),Integer.parseInt(tab[2])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (var x: statki) {
            System.out.println(x.toString((Ship ship)->{

                return "nazwa="+ship.getName()+";uzbrojenie="+ship.getAmountOfWeapons()+";stan="+ship.getWeaponsState();
            }));
        }

    }

}
