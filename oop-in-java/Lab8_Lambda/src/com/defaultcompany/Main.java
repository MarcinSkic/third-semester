package com.defaultcompany;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Ex2();
    }

    public static void Ex1(){
        ArrayList<String> words = new ArrayList<String>();
        words.add("Banan");
        words.add("Japko");
        words.add("Pomarancza");
        words.add("Kiwi");
        words.add("Mandarynka");
        words.add("Granat");
        words.add("Cytryna");
        showStrings(words,(s) -> {
            System.out.println(s);
        });
    }

    public static void showStrings(ArrayList<String> strings, StringShow stringShow){
        for (var s: strings
             ) {
            stringShow.hahaMethod(s);
        }
    }

    public static void Ex2(){
        Integer ints[] = new Integer[30];
        for(int i = 0; i < 30; i++) {
            Random random = new Random();
            ints[i] = random.nextInt(0,1234);
        }

        Arrays.sort(ints,(a, b) -> b-a);
        for (var x:
             ints) {
            System.out.println(x);
        }

    }

    public static void Ex3(){
        ArrayList<String> words = new ArrayList<String>();
        words.add("Banan");
        words.add("Japko");
        words.add("Pomarancza");
        words.add("Kiwi");
        words.add("Mandarynka");
        words.add("Granat");
        words.add("Cytryna");

        ShowArray(words);

        words.sort((a,b) -> {
            if(a.length() <= b.length()){
                return 1;
            } else if(a.length() == b.length()){
                return 0;
            } else {
                return -1;
            }
        });

        ShowArray(words);
    }

    public static  void ShowArray(ArrayList array){
        for (var x:
                array) {
            System.out.println(x+" ");
        }
    }

    public static void Example(){
        ArrayList<Integer> ints = new ArrayList<Integer>();
        for(int i = 0; i < 30; i++) {
            Random random = new Random();
            ints.add(random.nextInt(0, 1421));
        }

        ints.sort((a,b) -> {
            if(a<=b ){
                return -1;
            } else if(a==b) {
                return 0;
            } else {
                return 1;
            }
        });
        ShowArray(ints);
    }
}
