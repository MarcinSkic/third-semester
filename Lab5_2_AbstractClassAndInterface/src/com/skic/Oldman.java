package com.skic;

public class Oldman extends Adult implements Basic, Emerytura{
    @Override
    public void hollidays() {
        System.out.println("Juz nie dla mnie przyjemnosci");
    }

    @Override
    public void dates() {
        System.out.println("Moj czas minal");
    }

    @Override
    public void sleep() {
        System.out.println("Ciezkie spanko");
    }

    @Override
    public void wakeUp() {
        System.out.println("Ciezkie wstawanko");
    }

    @Override
    public void getRent() {
        System.out.println("Listonosz przyniosl rente");
    }

    @Override
    public void goToDoctor() {
        System.out.println("Boli mnie w krzyzu");
    }

    @Override
    public void nap() {
        System.out.println("Nie mam sily, drzemne sie");
    }

    @Override
    public void meaninglessTripToTown() {
        System.out.println("Na targ i do piekarni w godzinach szczytu >: >");
    }
}
