package com.defaultcompany;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    Ex5();
    }

    public static void Ex2(){
        int temp, suma = 0, iloczyn = 1;
        ArrayList<Integer> lista = new ArrayList<Integer>();
        Scanner read = new Scanner(System.in);
        while((temp = read.nextInt())!= 0){
            lista.add(temp);
        }
        System.out.println("Ilosc liczb: " + lista.size());
        for (var x: lista) {
            suma += x;
            iloczyn *= x;
        }

        System.out.println("Suma: " + suma);
        System.out.println("Iloczyn " + iloczyn);
    }

    public static void Ex3(){
        int temp, suma = 0, iloczyn = 1;
        ArrayList<Integer> lista = new ArrayList<Integer>();
        Scanner read = new Scanner(System.in);
        while(true){
            temp = read.nextInt();
            lista.add(temp);
            suma += temp;
            iloczyn *= temp;
            System.out.println("suma: "+ suma + "\niloczyn: " + iloczyn);
            if(Math.abs(suma) >= 250 || Math.abs(iloczyn) >= 3000000){
                break;
            }
        }
        lista.sort(Collections.reverseOrder());
        for (var x: lista) {
            System.out.print(x+" ");
        }
    }

    public static void Ex4(){
        int temp, suma = 0, iloczyn = 1;
        ArrayList<Integer> lista = new ArrayList<Integer>();
        Scanner read = new Scanner(System.in);
        while(true){
            temp = read.nextInt();
            lista.add(temp);
            suma += temp;

            if(suma >= 64){
                lista.sort(Collections.reverseOrder());
                suma -= lista.remove(0);
                System.out.println("Usuwanko!");
            }

            for (var x: lista) {
                System.out.print(x+" ");
            }
        }
    }

    public static void Ex5(){
        int temp, suma = 0, iloczyn = 1;
        ArrayList<Integer> lista = new ArrayList<Integer>();
        Scanner read = new Scanner(System.in);
        while(true){
            temp = read.nextInt();
            lista.add(temp);
            iloczyn *= temp;

            while(iloczyn >= 256){
                lista.sort(Collections.reverseOrder());
                iloczyn /= lista.remove(lista.size()-1);
                System.out.println("Usuwanko!");
            }

            for (var x: lista) {
                System.out.print(x+" ");
            }
        }
    }
}
