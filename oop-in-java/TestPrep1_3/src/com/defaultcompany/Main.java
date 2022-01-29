package com.defaultcompany;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    SHIP stateczek = new SHIP("Bismarck",40000);
	    SHIP stateczek2 = new SHIP("Hood",57000);

        ArrayList<SHIP> stateczki = new ArrayList<SHIP>();
        stateczki.add(stateczek);
        stateczki.add(stateczek2);
        SaveToFile(stateczki);
    }

    public static void SaveToFile(ArrayList<SHIP> stateczki){
        try {
            FileWriter write = new FileWriter(new File("Dane.txt"),true);
            for (var x: stateczki
                 ) {
                write.append(x.toString()+"\n");
            }
            write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
