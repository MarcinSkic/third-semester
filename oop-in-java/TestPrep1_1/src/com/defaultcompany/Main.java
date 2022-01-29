package com.defaultcompany;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        for (var x: args) {
            System.out.println(x);
        }
        //SaveToFile();

        /*var lista = ReadFromFile();

        SortAlphabeticalyWithLambda(lista);



        ShowText(() -> {
            System.out.println("O to twoja odpowiedz");
        });*/

        Watki();

    }

    public static void ShowText(ShowMeWhatYouGot show){
        show.ShowAnswer();
    }

    public static void SaveToFile(){
        FileWriter savior;
        try {
            savior = new FileWriter(new File("TestaRobimyPanowie!.txt"),true);
            savior.append("Hahahahhahah\n");
            savior.append("Glupol z ciebie\n");
            savior.append("I to taki wielki\n");

            savior.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> ReadFromFile(){
        try {
            ArrayList<String> lista = new ArrayList<String>();
            String linia;
            BufferedReader reader = new BufferedReader(new FileReader(new File("TestaRobimyPanowie!.txt")));
            while((linia = reader.readLine())!= null){
                System.out.println(linia);
                lista.add(linia);
            }
            return lista;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void SortListWithLambda(ArrayList<String> lista){
        lista.sort((String a, String b) -> {
            return b.length()-a.length();
        });
        System.out.println(lista.toString());
    }

    public static void SortAlphabeticalyWithLambda(ArrayList<String> lista){
        lista.sort((String a, String b)->{
            int size;
            if(a.length()>b.length()){
                size = b.length();
            } else {
                size = a.length();
            }
            for(int i = 0; i < size;i++){
                if(a.charAt(i) != b.charAt(i)){
                    return  ((int)b.charAt(i))-((int)a.charAt(i));
                }
            }
            if(a.length() == b.length()){
                return 0;
            } else {
                return a.length()-b.length();
            }
        });
    }

    public static void Watki(){
        Thread watek = new Thread(new cos("watek"));
        Thread watek2 = new Thread(new cos("watek2"));
        Thread watek3 = new Thread(new cos("watek3"));
        Thread watek4 = new Thread(new cos("watek4"));
        Thread watek5 = new Thread(new cos("watek5"));
        Thread watek6 = new Thread(new cos("watek6"));
        Thread watek7 = new Thread(new cos("watek7"));
        Thread watek8 = new Thread(new cos("watek8"));
        Thread watek9 = new Thread(new cos("watek9"));

        watek.run();
        watek2.run();
        watek3.run();
        watek4.run();
        watek5.run();
        watek6.run();
        watek7.run();
        watek8.run();
        watek9.run();
    }

    public synchronized void Metoda(){

    }
}
