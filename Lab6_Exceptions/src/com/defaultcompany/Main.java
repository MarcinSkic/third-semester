package com.defaultcompany;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static float a,b;
    static int x;

    public static void main(String[] args){
        Ex2();
    }

    public static void Ex3(){
        while(true){
            try{
                GetInteger();
            } catch (ArithmeticException e){
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        int result = 0;
        while(x > 0){
            result += (int) Math.pow(x%10,2);
            x /= 10;
        }
        System.out.println("Wynik: " + result);
    }

    public static void GetInteger() throws ArithmeticException{
        while (true) {
            int number = 0;
            Scanner read = new Scanner(System.in);
            try {
                System.out.print("Podaj liczbe calkowita <99,999>: ");
                number = read.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Podaj poprawna wartosc");
                continue;
            }
            if(number < 99 || number > 999){
                throw new ArithmeticException("Wartosc poza skala");
            }
            x = number;
            break;
        }
    }

    public static void Ex2(){
        int cecha = 0;

        GetNumber();

        System.out.println("Przypisywansko");
        float mantysa = a,result = 0;
        System.out.println(a);

        while(mantysa>=1){
            mantysa/=10;
            cecha++;
        }
        System.out.println("cecha: "+ cecha+ "mantysa: "+ mantysa);
        try{
            result = cecha/mantysa;
        } catch (ArithmeticException e){
            System.out.println("Sprobuj ponownie");
            Ex2();
        }
        System.out.println("Wynik: " + result);
    }



    public static void Ex1(){
        System.out.println("What do you want to do?");
        System.out.println("Dodawanie - 1\nOdejmowanie - 2\nMnozenie - 3\nDzielenie - 4\nPotegowanie - 5\nPierwiastkowanie - 6");

        int choice;
        float result = 0;
        Scanner read = new Scanner(System.in);

        System.out.print("Podaj wybor: ");
        choice = read.nextInt();

        switch (choice){
            case 1:
                GetAandB();
                result = a+b;
                break;
            case 2:
                GetAandB();
                result = a-b;
                break;
            case 3:
                GetAandB();
                result = a*b;
                break;
            case 4:
                while(true){
                    try{
                        GetAandB();
                        result = a/b;
                    } catch (ArithmeticException e) {
                        System.out.println("Podaj poprawny dzielnik");
                        continue;
                    }
                    break;
                }
                break;
            case 5:
                while(true){
                    try{
                        GetNumber();
                        result =(float) Math.sqrt(a);
                        break;
                    }catch (ArithmeticException e){
                        System.out.println("Podaj liczbe nie ujemna");
                        continue;
                    }
                }
            case 6:
                GetNumber(0,"Podaj liczbe potegowana: ");
                GetNumber(1,"Podaj stopien potegi: ");
                result = (float) Math.pow(a,b);
        }
        System.out.println("Wynik: " + result);
    }

    public static void GetAandB(){
        GetNumber(0,"Podaj a: ");
        GetNumber(1,"Podaj b: ");
    }

    public static void GetNumber(){
        GetNumber(0,"Podaj liczbe: ");
    }

    public static void GetNumber(int i, String prompt){
        while (true){
            float number = 0;
            Scanner read = new Scanner(System.in);
            try{
                System.out.print(prompt);
                number = read.nextFloat();
            } catch (InputMismatchException e) {
                System.out.println("Podaj poprawna wartosc");
                continue;
            }
            switch (i){
                case 0:
                    a = number;
                    break;
                case 1:
                    b = number;
                    break;
                default:
                    System.out.println("Sprobuj ponownie");
                    GetNumber(i,prompt);
            }
            break;
        }

    }


}

