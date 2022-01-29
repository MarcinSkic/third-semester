package com.defaultcompany;

import java.io.*;
import java.util.ArrayList;

public class SaveFile {
    String buffor = new String();
    int saves = 0;
    public void SaveLastPositions(Panel.Kula k1, Panel.Kula k2){
        buffor += new Position(k1.x,k1.y,k1.size)+";";
        buffor += new Position(k2.x,k2.y,k2.size)+"\n";
        saves++;
        if(saves >= 10){
            SaveToFile();
            buffor = "";
            saves = 0;
        }
    }

    public void SaveToFile(){
        File file = new File("Zderzenia.txt");

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            fileWriter.append(buffor);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Position> LoadFromFile(){
        ArrayList<Position> positions = new ArrayList<Position>();
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("Zderzenia.txt")));
            String linia = null;
            String[] rawPositions = null;

            while((linia = bufferedReader.readLine()) != null){
                System.out.println(linia);
                rawPositions = linia.split(";");
                System.out.println(rawPositions[0]);
                System.out.println(rawPositions[1]);
                for (var x: rawPositions) {
                    String[] temp = x.split(":");
                    System.out.println(temp[0]);
                    System.out.println(temp[1]);
                    System.out.println(temp[2]);
                    positions.add(new Position(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]),Integer.parseInt(temp[2])));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return positions;
    }



}

